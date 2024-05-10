package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Libro;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer>{
    
}
