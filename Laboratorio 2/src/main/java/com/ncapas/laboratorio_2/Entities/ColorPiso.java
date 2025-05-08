package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorPiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idColorPiso;

    @Column
    private String codigo;

    @Column
    private String color;
}
