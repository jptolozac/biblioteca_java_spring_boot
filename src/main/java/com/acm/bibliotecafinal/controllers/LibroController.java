package com.acm.bibliotecafinal.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bibliotecafinal.models.Libro;
import com.acm.bibliotecafinal.services.impl.LibroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    LibroService libroService;

    @GetMapping("")
    public ResponseEntity<List<Libro>> getUsuarios() {
        return ResponseEntity.ok().body(libroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibro(@PathVariable int id) {
        return ResponseEntity.ok().body(libroService.get(id));
    }
}