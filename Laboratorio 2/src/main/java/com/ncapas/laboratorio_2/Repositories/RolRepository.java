package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByIdRol(Integer idRol);

    @Query("SELECT r FROM Rol r WHERE r.nombre = :Nombre")
    Rol findByNombre(String Nombre);
}
