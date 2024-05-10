package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Editorial;

public interface IEditorialService {
    public Editorial get(int id);
    public List<Editorial> listar();
    public Editorial agregar(Editorial editorial);
    public Editorial actualizar(Editorial editorial);
    public void Eliminar(Editorial editorial);
}
