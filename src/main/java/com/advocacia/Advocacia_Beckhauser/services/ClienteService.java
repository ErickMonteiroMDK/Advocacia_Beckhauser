package com.advocacia.Advocacia_Beckhauser.services;


import com.advocacia.Advocacia_Beckhauser.models.Cliente;
import com.advocacia.Advocacia_Beckhauser.models.PessoaJuridica;
import com.advocacia.Advocacia_Beckhauser.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;


    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

}
