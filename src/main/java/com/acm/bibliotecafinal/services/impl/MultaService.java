package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Multa;
import com.acm.bibliotecafinal.repository.IMultaRepository;
import com.acm.bibliotecafinal.services.IMultaService;

@Service
public class MultaService implements IMultaService{
    @Autowired
    IMultaRepository multaRepository;

    @Override
    public Multa get(int id) {
        return multaRepository.findById(id).get();
    }

    @Override
    public List<Multa> listar() {
        return multaRepository.findAll();
    }

    @Override
    public Multa agregar(Multa multa) {
        return multaRepository.save(multa);
    }

    @Override
    public Multa actualizar(Multa multa) {
        return multaRepository.save(multa);
    }

    @Override
    public void Eliminar(Multa multa) {
        multaRepository.delete(multa);
    }
}
