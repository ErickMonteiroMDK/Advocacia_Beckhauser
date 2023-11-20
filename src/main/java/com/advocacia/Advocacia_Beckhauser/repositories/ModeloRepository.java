package com.advocacia.Advocacia_Beckhauser.repositories;

import com.advocacia.Advocacia_Beckhauser.models.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
