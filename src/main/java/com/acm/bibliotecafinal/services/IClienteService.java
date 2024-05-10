package com.acm.bibliotecafinal.services;

import java.util.List;

import com.acm.bibliotecafinal.models.Cliente;


public interface IClienteService {
    public Cliente get(String cedula);
    public List<Cliente> listar();
    public Cliente agregar(Cliente cliente);
    public Cliente actualizar(Cliente cliente);
    public void Eliminar(Cliente cliente);
}
