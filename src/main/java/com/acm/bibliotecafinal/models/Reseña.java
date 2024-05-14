package com.acm.bibliotecafinal.models;

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
public class Reseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String titulo;
    @Column(length = 1000)
    String descripcion;
    @ManyToOne
    Cliente cliente;
    @ManyToOne
    Libro libro;
    public Reseña(String titulo, String descripcion, Cliente cliente, Libro libro) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.libro = libro;
    }
    
}
