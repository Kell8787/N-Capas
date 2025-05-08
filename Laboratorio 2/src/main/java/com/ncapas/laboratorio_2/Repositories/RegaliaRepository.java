package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Regalia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegaliaRepository extends JpaRepository<Regalia, Integer> {
    @Query("SELECT r FROM Regalia r WHERE r.nombre = :nombre")
    Regalia findByNombre(String nombre);

    List<Regalia> findByPuntos (Integer puntos);
}
