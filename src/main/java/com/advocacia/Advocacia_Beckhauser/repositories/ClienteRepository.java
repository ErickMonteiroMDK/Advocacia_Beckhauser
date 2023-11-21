package com.advocacia.Advocacia_Beckhauser.repositories;

import com.advocacia.Advocacia_Beckhauser.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByEmail(String email);
    public Cliente findByTelefone(String telefone);
    public Cliente findByCpf(String cpf);
    public Cliente findByRg(String rg);
}
