package com.acm.bibliotecafinal.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String nombre;
    @Column
    String pais;
    @OneToMany(mappedBy = "editorial", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonIgnore
    List<Libro> libros;

    public Editorial(String nombre, String pais){
        this.nombre = nombre;
        this.pais = pais;
    }
}
