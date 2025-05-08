package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.SalonEventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalonEventosRepository extends JpaRepository<SalonEventos, Integer> {
    List<SalonEventos> findByNombre(String nombre);

    @Query(value = "SELECT se FROM salon_eventos se WHERE se.capacidad = :capacidad", nativeQuery = true)
    List<SalonEventos> findByCapacidad(Integer capacidad);

    @Query("SELECT se FROM SalonEventos se WHERE se.idSalonEventos = :idSalonEventos")
    SalonEventos findByIdSalonEventos(Integer idSalonEventos);
}
