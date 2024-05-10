package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Multa;


public interface IMultaService {
    public Multa get(int id);
    public List<Multa> listar();
    public Multa agregar(Multa multa);
    public Multa actualizar(Multa multa);
    public void Eliminar(Multa multa);
}
