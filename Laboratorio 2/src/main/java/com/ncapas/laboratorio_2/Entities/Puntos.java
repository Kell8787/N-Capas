package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Puntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPuntos;

    @Column
    private Integer puntaje;
}
