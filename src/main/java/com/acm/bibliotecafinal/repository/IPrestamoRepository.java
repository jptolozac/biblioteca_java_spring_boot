package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Prestamo;

@Repository
public interface IPrestamoRepository extends JpaRepository<Prestamo, Integer>{
    
}
