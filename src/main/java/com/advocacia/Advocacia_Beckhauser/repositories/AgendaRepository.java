package com.advocacia.Advocacia_Beckhauser.repositories;

import com.advocacia.Advocacia_Beckhauser.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository <Agenda, Long> {

}

