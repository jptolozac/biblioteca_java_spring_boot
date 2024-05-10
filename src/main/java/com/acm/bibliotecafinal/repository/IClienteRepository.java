package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, String>{
    
}
