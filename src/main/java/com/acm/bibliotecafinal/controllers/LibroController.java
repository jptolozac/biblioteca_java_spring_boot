package com.acm.bibliotecafinal.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bibliotecafinal.dto.LibroDTO;
import com.acm.bibliotecafinal.dto.Response;
import com.acm.bibliotecafinal.models.Autor;
import com.acm.bibliotecafinal.models.Categoria;
import com.acm.bibliotecafinal.models.Editorial;
import com.acm.bibliotecafinal.models.Libro;
import com.acm.bibliotecafinal.services.impl.AutorService;
import com.acm.bibliotecafinal.services.impl.CategoriaService;
import com.acm.bibliotecafinal.services.impl.EditorialService;
import com.acm.bibliotecafinal.services.impl.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    LibroService libroService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    AutorService autorService;
    @Autowired
    EditorialService editorialService;

    @GetMapping("")
    public ResponseEntity<List<Libro>> getUsuarios() {
        return ResponseEntity.ok().body(libroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibro(@PathVariable int id) {
        return ResponseEntity.ok().body(libroService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deltelibro(@PathVariable int id) {
        Response response = null;
        Libro libro = libroService.get(id);

        try {
            libroService.Eliminar(libro);
            response = new Response(false, "Se eliminó el libro con id " + libro.getId() + " correctamente");
        } catch (Exception e) {
            response = new Response(true, e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar")
    public ResponseEntity<Libro> editarlibro(@RequestBody @valid LibroDTO libroDTO) {
        Response response = null;
        Categoria categoria = categoriaService.get(libroDTO.getCategoria());
        Autor autor = autorService.get(libroDTO.getAutor());
        Editorial editorial = editorialService.get(libroDTO.getEditorial());
        // List prestamos = new Prestamo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        LocalDate localDate = LocalDate.parse(String.valueOf(libroDTO.getAñoPublicacion()), formatter);
        Libro libro = Libro.builder()
                .id(libroDTO.getId())
                .añoPublicacion(localDate.toString())
                .disponibilidad(libroDTO.getDisponibilidad())
                .titulo(libroDTO.getTitulo())
                .autor(autor)
                .categoria(categoria)
                .editorial(editorial)
                .prestamos(null)
                .reseñas(null)
                .build();
        try {
            libroService.actualizar(libro);
        } catch (Exception e) {
            response = new Response(true, e.getMessage());
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Libro> agregarlibro(@RequestBody @valid LibroDTO libroDTO) {
        Response response = null;
        Categoria categoria = categoriaService.get(libroDTO.getCategoria());
        Autor autor = autorService.get(libroDTO.getAutor());
        Editorial editorial = editorialService.get(libroDTO.getEditorial());
        // List prestamos = new Prestamo();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
        LocalDate localDate = LocalDate.parse(String.valueOf(libroDTO.getAñoPublicacion()), formatter);
        Libro libro = Libro.builder()
                .añoPublicacion(localDate.toString())
                .disponibilidad(libroDTO.getDisponibilidad())
                .titulo(libroDTO.getTitulo())
                .autor(autor)
                .categoria(categoria)
                .editorial(editorial)
                .prestamos(null)
                .reseñas(null)
                .build();
        try {
            libroService.agregar(libro);
        } catch (Exception e) {
            response = new Response(true, e.getMessage());
        }
        return ResponseEntity.ok(libro);
    }

}