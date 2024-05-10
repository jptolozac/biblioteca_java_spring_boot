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
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String descripcion;
    @Column
    double precio;
    @Column
    boolean estado;
    @ManyToOne
    Cliente cliente;
    public Multa(String descripcion, double precio, boolean estado, Cliente cliente) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.cliente = cliente;
    }
    
}
