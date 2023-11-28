package com.advocacia.Advocacia_Beckhauser.repositories;

import com.advocacia.Advocacia_Beckhauser.models.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvogadoRepository extends JpaRepository <Advogado, Long> {

    public Advogado findByCpf (String Cpf);

    public Advogado findByOab (String Oab);
}
