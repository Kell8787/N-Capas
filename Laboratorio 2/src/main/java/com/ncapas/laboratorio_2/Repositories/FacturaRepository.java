package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Factura;
import com.ncapas.laboratorio_2.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    List<Factura> findByReserva(Reserva reserva);

    @Query("SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    Factura findByIdFactura(Integer idFactura);

    @Query(value = "SELECT f FROM Factura f WHERE f.fecha BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    List<Factura> findByFechaBetween(String fechaInicio, String fechaFin);
}
