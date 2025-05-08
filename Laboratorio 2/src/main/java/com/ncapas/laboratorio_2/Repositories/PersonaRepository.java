package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Persona;
import com.ncapas.laboratorio_2.Entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, UUID> {
    List<Persona> findByRole(Rol role);

    @Query("SELECT p FROM Persona p WHERE LOWER(p.nombre) = LOWER(:nombre)")
    List<Persona> findByNombre(String nombre);

    @Query(value = "SELECT * FROM persona WHERE LOWER(correo) LIKE(CONCAT('%', :correo, '%'))", nativeQuery = true)
    List<Persona> findByCorreo(String correo);
}
