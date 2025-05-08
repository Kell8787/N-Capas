package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, UUID> {

}
