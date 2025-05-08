package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenTrabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdenTrabajo;

    @Column
    private String descripcion;

    @Column
    private String fecha;

    @ManyToOne
    @JoinColumn(name="id_empleado", nullable = false, foreignKey = @ForeignKey(name = "fk_ot_empleado"))
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="id_habitacion", nullable = false, foreignKey = @ForeignKey(name = "fk_ot_habitacion"))
    private Habitacion habitacion;
}
