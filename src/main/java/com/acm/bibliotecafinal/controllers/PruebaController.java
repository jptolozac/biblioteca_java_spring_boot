package com.acm.bibliotecafinal.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.acm.bibliotecafinal.models.Autor;
import com.acm.bibliotecafinal.models.Categoria;
import com.acm.bibliotecafinal.models.Editorial;
import com.acm.bibliotecafinal.models.Libro;
import com.acm.bibliotecafinal.services.IAutorService;
import com.acm.bibliotecafinal.services.ICategoriaService;
import com.acm.bibliotecafinal.services.IEditorialService;
import com.acm.bibliotecafinal.services.ILibroService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PruebaController {
    @Autowired
    IEditorialService editorialService;
    @Autowired
    ICategoriaService categoriaService;
    @Autowired
    IAutorService autorService;
    @Autowired
    ILibroService libroService;

    @GetMapping("/")
    public List<Libro> getMethodName(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String pais) {
        
        if(id != null && nombre != null && pais != null){
            Editorial editorial = new Editorial(nombre, pais);
            editorial = editorialService.agregar(editorial);
            System.out.println(editorial);

            Categoria categoria = new Categoria("accion", "Dar bala");
            categoria = categoriaService.agregar(categoria);

            Autor autor = new Autor("nombre", "pais");
            autor = autorService.agregar(autor);

            Libro libro = new Libro("2024", 1, categoria, autor, editorial);
            libro = libroService.agregar(libro);
        }
        /* Editorial nuevaEditorial = new Editorial();
        nuevaEditorial.setNombre("nuevonombre");
        nuevaEditorial.setPais("nuevopais");
        editorialService.actualizar(nuevaEditorial);
        editorialService.Eliminar(nuevaEditorial); */

        return libroService.listar();
    }

}
