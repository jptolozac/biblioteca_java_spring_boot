package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Reseña;


public interface IReseñaService {
    public Reseña get(int id);
    public List<Reseña> listar();
    public Reseña agregar(Reseña reseña);
    public Reseña actualizar(Reseña reseña);
    public void Eliminar(Reseña reseña);
}
