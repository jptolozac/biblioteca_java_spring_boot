package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Libro;
import com.acm.bibliotecafinal.repository.ILibroRepository;
import com.acm.bibliotecafinal.services.ILibroService;

@Service
public class LibroService implements ILibroService{
    @Autowired
    ILibroRepository libroRepository;

    @Override
    public Libro get(int id) {
        return libroRepository.findById(id).get();
    }

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Libro agregar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro actualizar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void Eliminar(Libro libro) {
        libroRepository.delete(libro);
    }
    
}
