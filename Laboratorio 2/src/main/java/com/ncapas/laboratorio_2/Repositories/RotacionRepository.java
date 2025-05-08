package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Rotacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface RotacionRepository extends JpaRepository<Rotacion, Integer> {
    Rotacion findByTurno(String turno);

    @Query(value = "SELECT r FROM Rotacion r WHERE r.id_empleado = :empleado", nativeQuery = true)
    Rotacion findByEmpleado(String empleado);
}
