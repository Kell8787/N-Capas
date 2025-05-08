package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonEventos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSalonEventos;

    @Column
    private String nombre;

    @Column
    private Integer capacidad;

    @Column
    private String descripcion_ornamentos;
}
