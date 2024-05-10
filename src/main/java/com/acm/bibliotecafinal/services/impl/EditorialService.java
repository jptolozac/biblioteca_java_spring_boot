package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Editorial;
import com.acm.bibliotecafinal.repository.IEditorialRepository;
import com.acm.bibliotecafinal.services.IEditorialService;

@Service
public class EditorialService implements IEditorialService{
    @Autowired
    IEditorialRepository editorialRepository;

    @Override
    public Editorial agregar(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public List<Editorial> listar() {
        return editorialRepository.findAll();
    }

    @Override
    public Editorial get(int id) {
        return editorialRepository.findById(id).get();
    }

    @Override
    public Editorial actualizar(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    @Override
    public void Eliminar(Editorial editorial) {
        editorialRepository.delete(editorial);
    }
    
}
