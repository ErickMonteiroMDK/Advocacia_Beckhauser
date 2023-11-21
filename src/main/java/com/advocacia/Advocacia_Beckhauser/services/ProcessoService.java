package com.advocacia.Advocacia_Beckhauser.services;

import com.advocacia.Advocacia_Beckhauser.models.PessoaJuridica;
import com.advocacia.Advocacia_Beckhauser.models.Processo;
import com.advocacia.Advocacia_Beckhauser.repositories.PessoaJuridicaRepository;
import com.advocacia.Advocacia_Beckhauser.repositories.ProcessoRepository;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository repository;

    public Processo salvar(Processo entity) { return  repository.save(entity);}

    public List<Processo> buscaTodos() { return  repository.findAll();}

    public Processo buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Processo alterar(Long id, Processo alterado) {
        Optional<Processo> encontrado = repository.findById(id);
        if(encontrado.isPresent()) {
            Processo processo = encontrado.get();
            processo.setAtaque(alterado.getAtaque());
            processo.setDefesa(alterado.getDefesa());
            processo.setNumero(alterado.getNumero());
            return repository.save(processo);
        }
        return null;}

    public void remover(Long id) { repository.deleteById(id);}
}
