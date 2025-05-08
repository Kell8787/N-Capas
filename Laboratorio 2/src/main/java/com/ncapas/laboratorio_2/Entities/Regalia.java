package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regalia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegalia;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Integer puntos;
}
