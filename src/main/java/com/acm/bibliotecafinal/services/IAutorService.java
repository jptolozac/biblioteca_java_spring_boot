package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Autor;

public interface IAutorService {
    public Autor get(int id);
    public List<Autor> listar();
    public Autor agregar(Autor autor);
    public Autor actualizar(Autor autor);
    public void Eliminar(Autor autor);
}
