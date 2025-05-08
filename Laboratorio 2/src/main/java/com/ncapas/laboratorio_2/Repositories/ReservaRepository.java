package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByEstado(Boolean estado);

    @Query(value = "SELECT r FROM reserva r WHERE r.id_reserva = :idFactura", nativeQuery = true)
    List<Reserva> findByFacturaIdFactura(Integer idFactura);

    @Query("SELECT r FROM Reserva r WHERE r.huesped.idHuesped = :idHuesped")
    List<Reserva> findByHuespedIdHuesped(Integer idHuesped);
}
