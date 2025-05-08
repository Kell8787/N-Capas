package com.ncapas.laboratorio_2.Repositories;

import com.ncapas.laboratorio_2.Entities.ColorPiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ColorPisoRepository extends JpaRepository<ColorPiso, Integer> {
    List<ColorPiso> findByCodigo (String codigo);

    @Query("SELECT c FROM ColorPiso c WHERE c.color = :color")
    List<ColorPiso> findByColor (String color);

    @Query(value = "SELECT c FROM ColorPiso c WHERE c.idColorPiso = :idColorPiso", nativeQuery = true)
    ColorPiso findByIdColorPiso (Integer idColorPiso);

}
