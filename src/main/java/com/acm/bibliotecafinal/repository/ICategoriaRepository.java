package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
