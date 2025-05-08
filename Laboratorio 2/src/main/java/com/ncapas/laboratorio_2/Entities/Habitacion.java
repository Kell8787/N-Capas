package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion", insertable = false, updatable = false)
    private Integer idHabitacion;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private Boolean tiene_balcon;

    @ManyToOne
    @JoinColumn(name="id_persona", nullable = false, foreignKey = @ForeignKey(name = "fk_hus_persona"))
    private Persona persona;
}
