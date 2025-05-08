package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Puntos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntosRepository extends JpaRepository<Puntos, Integer> {
    @Query("Select P FROM Puntos P WHERE P.idPuntos = :idPuntos")
    Puntos findByIdPuntos(Integer idPuntos);

    @Query("Select P FROM Puntos P WHERE P.puntaje = :puntaje")
    Puntos findByPuntaje(Integer puntaje);
}
