package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonalRepository extends JpaRepository<Persona, UUID> {

}
