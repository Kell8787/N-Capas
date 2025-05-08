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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idPersona;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column (unique = true)
    private String correo;

    @Column
    private String contrasena;

    @Column
    private String fecha_nacimiento;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false, foreignKey = @ForeignKey (name = "fk_id_role"))
    private Rol role;

}
