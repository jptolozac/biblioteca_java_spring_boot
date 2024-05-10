package com.acm.bibliotecafinal.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class Cliente {
    @Id
    @Column
    String cedula;
    @Column
    String nombre;
    @Column
    String correo;
    @Column
    String contraseña;
    @Column
    String telefono;
    @Column
    String estadoCuenta;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonIgnore
    List<Multa> multas;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonIgnore
    List<Reseña> reseñas;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonIgnore
    List<Prestamo> prestamos;

    @OneToMany(targetEntity = Rol.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "cliente")
    // @JsonIgnore
    List<Rol> rol;

    public Cliente(String cedula, String nombre, String correo, String telefono, String estadoCuenta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.estadoCuenta = estadoCuenta;
    }
}
