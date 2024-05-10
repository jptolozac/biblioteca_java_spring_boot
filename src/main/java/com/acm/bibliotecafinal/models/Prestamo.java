package com.acm.bibliotecafinal.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    LocalDate fechaInicio;
    @Column
    LocalDate fechaFin;
    @ManyToOne
    Cliente cliente;
    @ManyToOne
    Libro libro;
    public Prestamo(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Libro libro) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.libro = libro;
    }
    
}
