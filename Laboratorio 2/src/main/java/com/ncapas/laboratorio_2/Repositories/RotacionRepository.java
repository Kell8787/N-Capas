package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Rotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotacionRepository extends JpaRepository<Rotacion, Integer> {

}
