package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @Column
    private String fecha_entrada;

    @Column
    private String fecha_salida;

    @Column
    private Boolean estado;

    @OneToOne
    @JoinColumn(name="id_reserva", nullable = false, foreignKey = @ForeignKey(name = "fk_re_factura"))
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="id_habitacion", nullable = false, foreignKey = @ForeignKey(name = "fk_re_habitacion"))
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name="id_salon", nullable = false, foreignKey = @ForeignKey(name = "fk_re_salon"))
    private SalonEventos salon;

    @ManyToOne
    @JoinColumn(name="id_huesped", nullable = false, foreignKey = @ForeignKey(name = "fk_re_huesped"))
    private Huesped huesped;
}
