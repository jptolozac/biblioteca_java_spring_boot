package com.acm.bibliotecafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acm.bibliotecafinal.models.Reseña;

@Repository
public interface IReseñaRepository extends JpaRepository<Reseña, Integer>{    
}
