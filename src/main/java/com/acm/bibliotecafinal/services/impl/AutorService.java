package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Autor;
import com.acm.bibliotecafinal.repository.IAutorRepository;
import com.acm.bibliotecafinal.services.IAutorService;

@Service
public class AutorService implements IAutorService{
    @Autowired
    IAutorRepository autorRepository;

    @Override
    public Autor get(int id) {
        return autorRepository.findById(id).get();
    }

    @Override
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @Override
    public Autor agregar(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor actualizar(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void Eliminar(Autor autor) {
        autorRepository.delete(autor);
    }
    
}
