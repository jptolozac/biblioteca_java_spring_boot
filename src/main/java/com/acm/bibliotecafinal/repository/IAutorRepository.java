package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer>{

}