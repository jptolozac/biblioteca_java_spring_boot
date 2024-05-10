package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Multa;

@Repository
public interface IMultaRepository extends JpaRepository<Multa, Integer>{
    
}
