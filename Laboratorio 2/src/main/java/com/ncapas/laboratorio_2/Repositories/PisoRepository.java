package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.ColorPiso;
import com.ncapas.laboratorio_2.Entities.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PisoRepository extends JpaRepository<Piso, Integer> {
    List<Piso> findByColor (ColorPiso colorPiso);

    @Query("SELECT p FROM Piso p WHERE p.numPiso = :numPiso")
    List<Piso> findByNumPiso (Integer numPiso);

    @Query(value = "SELECT p FROM Piso p WHERE p.sucursal.idSucursal = :idSucursal", nativeQuery = true)
    List<Piso> findBySucursal (Integer idSucursal);
}
