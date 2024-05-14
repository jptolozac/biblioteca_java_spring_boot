package com.acm.bibliotecafinal.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String titulo;
    @Column
    String añoPublicacion;
    @Column
    int disponibilidad;
    @ManyToOne
    // @JsonIgnore
    Categoria categoria;
    @ManyToOne
    // @JsonIgnore
    Autor autor;
    @ManyToOne
    // @JsonIgnore
    Editorial editorial;
    @OneToMany(mappedBy = "libro", fetch = FetchType.LAZY)
    @JsonIgnore
    List<Reseña> reseñas;
    @OneToMany(mappedBy = "libro", fetch = FetchType.LAZY)
    @JsonIgnore
    List<Prestamo> prestamos;
    
    public Libro(String añoPublicacion, int disponibilidad, Categoria categoria, Autor autor,
            Editorial editorial) {
        this.añoPublicacion = añoPublicacion;
        this.disponibilidad = disponibilidad;
        this.categoria = categoria;
        this.autor = autor;
        this.editorial = editorial;
    }
    
}
