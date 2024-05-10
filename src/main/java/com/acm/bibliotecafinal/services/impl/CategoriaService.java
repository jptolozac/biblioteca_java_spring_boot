package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Categoria;
import com.acm.bibliotecafinal.repository.ICategoriaRepository;
import com.acm.bibliotecafinal.services.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{
    @Autowired
    ICategoriaRepository categoriaRepository;

    @Override
    public Categoria get(int id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria agregar(Categoria autor) {
        return categoriaRepository.save(autor);
    }

    @Override
    public Categoria actualizar(Categoria autor) {
        return categoriaRepository.save(autor);
    }

    @Override
    public void Eliminar(Categoria autor) {
        categoriaRepository.delete(autor);
    }
}
