package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PisoRepository extends JpaRepository<Piso, Integer> {
}
