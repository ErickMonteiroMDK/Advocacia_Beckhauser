package com.advocacia.Advocacia_Beckhauser.services;

import com.advocacia.Advocacia_Beckhauser.models.PessoaJuridica;
import com.advocacia.Advocacia_Beckhauser.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository repository;

    public PessoaJuridica salvar(PessoaJuridica entity) { return  repository.save(entity);}

    public List<PessoaJuridica> buscaTodos() { return  repository.findAll();}


}
