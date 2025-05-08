package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
