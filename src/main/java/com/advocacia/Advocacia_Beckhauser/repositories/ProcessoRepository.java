package com.advocacia.Advocacia_Beckhauser.repositories;

import com.advocacia.Advocacia_Beckhauser.models.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;


@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long>{

    // public Processo findByNumero (String numero);


}
