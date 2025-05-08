package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersonal;

    @Column
    private String departamento;

    @Column
    private Boolean superior;

    @ManyToOne
    @JoinColumn(name="id_sucursal", nullable = false, foreignKey = @ForeignKey(name = "fk_empleado_sucursal"))
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name="id_persona", nullable = false, foreignKey = @ForeignKey(name = "fk_empleado_persona"))
    private Persona persona;
}
