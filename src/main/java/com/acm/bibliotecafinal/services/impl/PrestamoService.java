package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Prestamo;
import com.acm.bibliotecafinal.repository.IPrestamoRepository;
import com.acm.bibliotecafinal.services.IPrestamoService;

@Service
public class PrestamoService implements IPrestamoService{
    @Autowired
    IPrestamoRepository prestamoRepository;

    @Override
    public Prestamo get(int id) {
        return prestamoRepository.findById(id).get();
    }

    @Override
    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo agregar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo actualizar(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public void Eliminar(Prestamo prestamo) {
        prestamoRepository.delete(prestamo);
    }
}
