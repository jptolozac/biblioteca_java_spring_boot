package com.acm.bibliotecafinal.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.bibliotecafinal.models.Cliente;
import com.acm.bibliotecafinal.repository.IClienteRepository;
import com.acm.bibliotecafinal.services.IClienteService;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    IClienteRepository clienteRepository;

    @Override
    public Cliente get(String cedula) {
        return clienteRepository.findById(cedula).get();
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente agregar(Cliente autor) {
        return clienteRepository.save(autor);
    }

    @Override
    public Cliente actualizar(Cliente autor) {
        return clienteRepository.save(autor);
    }

    @Override
    public void Eliminar(Cliente autor) {
        clienteRepository.delete(autor);
    }
}
