package com.advocacia.Advocacia_Beckhauser.services;

import com.advocacia.Advocacia_Beckhauser.enterprise.ValidationException;
import com.advocacia.Advocacia_Beckhauser.models.Advogado;
import com.advocacia.Advocacia_Beckhauser.repositories.AdvogadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvogadoService {
    @Autowired
    private AdvogadoRepository repository;

    public Advogado salvar(Advogado entity) {
        if (repository.findByCpf(entity.getCpf()) != null) {
            throw new ValidationException("Este CPF já está cadastrado!!!");
        }

        if (repository.findByOab(entity.getOab()) != null) {
            throw new ValidationException("Esta OAB já está cadastrada!!!");
        }

        return repository.save(entity);
    }

    public List<Advogado> trazerTodos() { return repository.findAll(); }

    public Advogado trazerporId(Long id) {return repository.findById(id).orElse(null);}

    public void removerAdvogado(Long id) {repository.deleteById(id);}

    public Advogado alterarAdvogado(Long id, Advogado entity) {
        Optional<Advogado> porId = repository.findById(id);

        if(porId.isPresent()){
            Advogado advogado = porId.get();

            advogado.setNome(entity.getNome());
            advogado.setOab(entity.getOab());
            advogado.setTelefone(entity.getTelefone());
            advogado.setEmail(entity.getEmail());
            advogado.setEndereco(entity.getEndereco());
            advogado.setCpf(entity.getCpf());
            advogado.setRg(entity.getRg());
            advogado.setProfissao(entity.getProfissao());
            advogado.setDataNascimento(entity.getDataNascimento());

            return repository.save(advogado);
        }
        return null;


    }
}
