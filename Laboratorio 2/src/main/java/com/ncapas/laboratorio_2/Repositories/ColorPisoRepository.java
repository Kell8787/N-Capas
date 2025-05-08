package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.ColorPiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.tokens.Token;

@Repository
public interface ColorPisoRepository extends JpaRepository<ColorPiso, Integer> {

}
