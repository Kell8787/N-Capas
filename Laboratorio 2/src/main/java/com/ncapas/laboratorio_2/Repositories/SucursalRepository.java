package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
    List<Sucursal> findByIdSucursal(Integer idSucursal);

    @Query(value = "SELECT s FROM Sucursal s WHERE s.direccion_sucursal = :direccionSucursal", nativeQuery = true)
    List<Sucursal> findByDireccionSucursal(String direccionSucursal);

    @Query("SELECT s FROM Sucursal s WHERE s.nombreSucursal = :nombreSucursal")
    List<Sucursal> findByNombreSucursal(String nombreSucursal);
}
