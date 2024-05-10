package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Categoria;


public interface ICategoriaService {
    public Categoria get(int id);
    public List<Categoria> listar();
    public Categoria agregar(Categoria categoria);
    public Categoria actualizar(Categoria categoria);
    public void Eliminar(Categoria categoria);
}
