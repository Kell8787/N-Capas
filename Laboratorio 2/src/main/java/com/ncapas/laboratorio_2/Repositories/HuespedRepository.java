package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, UUID> {
    List<Huesped> findByIdHuesped(UUID idHuesped);

    @Query("SELECT h FROM Huesped h WHERE h.persona.nombre = :nombre")
    List<Huesped> findByNombre(String nombre);

}
