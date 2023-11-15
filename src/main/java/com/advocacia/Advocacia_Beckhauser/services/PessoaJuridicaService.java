package com.advocacia.Advocacia_Beckhauser.services;

import com.advocacia.Advocacia_Beckhauser.models.PessoaJuridica;
import com.advocacia.Advocacia_Beckhauser.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

    public PessoaJuridica salvar(PessoaJuridica entity) { return  repository.save(entity);}

    public List<PessoaJuridica> buscaTodos() { return  repository.findAll();}

    public PessoaJuridica buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PessoaJuridica alterar(Long id, PessoaJuridica alterado) {
        Optional<PessoaJuridica> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            PessoaJuridica pessoaJuridica = encontrado.get();
            pessoaJuridica.setCnpj(alterado.getCnpj());
            pessoaJuridica.setRazaoSocial(alterado.getRazaoSocial());
            pessoaJuridica.setTipoEmpresa(alterado.getTipoEmpresa());
            pessoaJuridica.setNome(alterado.getNome());
            pessoaJuridica.setEmail(alterado.getEmail());
            pessoaJuridica.setTelefone(alterado.getTelefone());
            pessoaJuridica.setEndereco(alterado.getEndereco());
            return repository.save(pessoaJuridica);
        }
        return null;}


}
