package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rotacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRotacion;

    @Column
    private String turno;

    @Column
    private String mes;

    @ManyToOne
    @JoinColumn(name="id_empleado", nullable = false, foreignKey = @ForeignKey(name = "fk_rot_empleado"))
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="id_piso", nullable = false, foreignKey = @ForeignKey(name = "fk_rot_piso"))
    private Piso piso;
}
