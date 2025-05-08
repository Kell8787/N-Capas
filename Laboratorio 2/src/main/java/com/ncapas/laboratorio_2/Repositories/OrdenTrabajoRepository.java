package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Empleado;
import com.ncapas.laboratorio_2.Entities.Habitacion;
import com.ncapas.laboratorio_2.Entities.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Integer> {
    List<OrdenTrabajo> findByIdOrdenTrabajo(Integer idOrdenTrabajo);

    @Query("SELECT ot FROM OrdenTrabajo ot WHERE ot.empleado = :empleado")
    List<OrdenTrabajo> findByEmpleado(Empleado empleado);

    @Query(value = "SELECT ot FROM OrdenTrabajo ot WHERE ot.habitacion.idHabitacion = :idHabitacion", nativeQuery = true)
    List<OrdenTrabajo> findByHabitacion(Habitacion Habitacion);

}
