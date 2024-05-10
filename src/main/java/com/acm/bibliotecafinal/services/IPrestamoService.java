package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Prestamo;

public interface IPrestamoService {
    public Prestamo get(int id);
    public List<Prestamo> listar();
    public Prestamo agregar(Prestamo prestamo);
    public Prestamo actualizar(Prestamo prestamo);
    public void Eliminar(Prestamo prestamo);
}
