package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Reseña;
import com.acm.bibliotecafinal.repository.IReseñaRepository;
import com.acm.bibliotecafinal.services.IReseñaService;

@Service
public class ReseñaService implements IReseñaService{
    @Autowired
    IReseñaRepository reseñaRepository;

    @Override
    public Reseña get(int id) {
        return reseñaRepository.findById(id).get();
    }

    @Override
    public List<Reseña> listar() {
        return reseñaRepository.findAll();
    }

    @Override
    public Reseña agregar(Reseña reseña) {
        return reseñaRepository.save(reseña);
    }

    @Override
    public Reseña actualizar(Reseña reseña) {
        return reseñaRepository.save(reseña);
    }

    @Override
    public void Eliminar(Reseña reseña) {
        reseñaRepository.delete(reseña);
    }
    
}
