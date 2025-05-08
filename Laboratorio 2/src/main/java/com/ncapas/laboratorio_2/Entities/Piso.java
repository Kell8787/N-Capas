package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPiso;

    @Column
    private String nombre;

    @Column
    private Integer numPiso;

    @ManyToOne
    @JoinColumn(name="id_sucursal", nullable = false, foreignKey = @ForeignKey(name = "fk_pi_sucursal"))
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name="id_color", nullable = false, foreignKey = @ForeignKey(name = "fk_pi_color"))
    private ColorPiso color;

    @ManyToOne
    @JoinColumn(name="id_salon", nullable = false, foreignKey = @ForeignKey(name = "fk_pi_salon"))
    private SalonEventos salon;

    @OneToMany
    @JoinColumn(name="id_habitacion", nullable = false, foreignKey = @ForeignKey(name = "fk_pi_habitacion"))
    private List<Habitacion> habitacion;


}
