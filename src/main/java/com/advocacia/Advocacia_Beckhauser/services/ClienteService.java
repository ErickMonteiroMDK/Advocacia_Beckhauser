package com.advocacia.Advocacia_Beckhauser.services;


import com.advocacia.Advocacia_Beckhauser.enterprise.ValidationException;
import com.advocacia.Advocacia_Beckhauser.models.Cliente;
import com.advocacia.Advocacia_Beckhauser.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;


    public Cliente salvar(Cliente cliente) {

        if (repository.findByEmail(cliente.getEmail()) != null){
            throw  new ValidationException("Email já cadastrado na base de dados!");
        }

        if (repository.findByTelefone(cliente.getTelefone()) != null){
            throw new ValidationException("Telefone já cadastrado na base de dados!");
        }

        if (repository.findByCpf(cliente.getCpf()) != null){
            throw new ValidationException("CPF já cadastrado na base de dados!");
        }

        if (repository.findByRg(cliente.getRg()) != null){
            throw new ValidationException("RG já cadastrado na base de dados!");
        }

        return repository.save(cliente);
    }

    public List<Cliente> buscaTodos(){
        return repository.findAll();
    }

    public Cliente buscaPorId(Long id){
       return repository.findById(id).orElse(null);
    }

    public Cliente atualizar(Long id, Cliente atualizado){
        Optional<Cliente> optional = repository.findById(id);
        if (optional.isPresent()){
            var cliente = optional.get();
            cliente.setNome(atualizado.getNome());
            cliente.setEmail(atualizado.getEmail());
            cliente.setEndereco(atualizado.getEndereco());
            cliente.setDataNascimento(atualizado.getDataNascimento());
            cliente.setProfissao(atualizado.getProfissao());
            cliente.setCpf(atualizado.getCpf());
            cliente.setRg(atualizado.getRg());
            cliente.setTelefone(atualizado.getTelefone());

            return repository.save(cliente);
        }

        return null;
    }

    public void deletarPorId(Long id){
        repository.deleteById(id);
    }

}
