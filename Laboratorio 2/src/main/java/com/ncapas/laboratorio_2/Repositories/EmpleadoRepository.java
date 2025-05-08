package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Empleado;
import com.ncapas.laboratorio_2.Entities.Persona;
import com.ncapas.laboratorio_2.Entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query("SELECT e FROM Empleado e Where e.persona.nombre = :nombre AND e.persona.apellido = :apellido")
    List<Empleado> findByNombre(String nombre, String apellido);

    @Query("SELECT e FROM Empleado e WHERE e.sucursal.idSucursal = :idSucursal")
    List<Empleado> findBySucursal(Sucursal idSucursal);

    List<Empleado> findBySuperior(Boolean superior);
}
