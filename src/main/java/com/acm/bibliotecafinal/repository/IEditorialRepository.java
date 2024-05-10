package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Editorial;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, Integer>{
    
}
