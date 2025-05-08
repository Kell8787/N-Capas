package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Habitacion;
import com.ncapas.laboratorio_2.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    List<Habitacion> findByTieneBalcon(Boolean tieneBalcon); // JPA Query

    @Query("SELECT h FROM Habitacion h WHERE h.nombre = :nombre")
    List<Habitacion> findByNombre(String nombre);

    @Query(value = "SELECT * FROM Habitacion h WHERE LOWER(descripcion) LIKE LOWER(CONCAT('%', :descripcion, '%'))", nativeQuery = true)
    List<Habitacion> findByDescripcion(String descripcion);

    List<Habitacion> findByPersona (Persona persona); // JPA Query
}
