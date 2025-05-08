package com.ncapas.laboratorio_2.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Huesped {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idHuesped;

    @ManyToOne
    @JoinColumn(name="id_persona", nullable = false, foreignKey = @ForeignKey(name = "fk_hus_persona"))
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="id_puntos", nullable = false, foreignKey = @ForeignKey(name = "fk_hus_puntos"))
    private Puntos puntos;

    @ManyToOne
    @JoinColumn(name="id_regalia", nullable = false, foreignKey = @ForeignKey(name = "fk_hus_regalia"))
    private Regalia regalia;
}
