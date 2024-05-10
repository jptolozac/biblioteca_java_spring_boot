package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Libro;


public interface ILibroService {
    public Libro get(int id);
    public List<Libro> listar();
    public Libro agregar(Libro libro);
    public Libro actualizar(Libro libro);
    public void Eliminar(Libro libro);
}
