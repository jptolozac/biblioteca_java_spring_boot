package com.acm.bibliotecafinal.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bibliotecafinal.dto.ReseñaDTO;
import com.acm.bibliotecafinal.dto.Response;
import com.acm.bibliotecafinal.models.Autor;
import com.acm.bibliotecafinal.models.Cliente;
import com.acm.bibliotecafinal.models.Libro;
import com.acm.bibliotecafinal.models.Reseña;
import com.acm.bibliotecafinal.services.impl.ClienteService;
import com.acm.bibliotecafinal.services.impl.LibroService;
import com.acm.bibliotecafinal.services.impl.ReseñaService;

@RestController
@RequestMapping("/reseña")
public class ReseñaController {
      @Autowired
      ReseñaService reseñaService;
      @Autowired
      ClienteService clienteService;
      @Autowired
      LibroService libroService;

      @GetMapping("")
    public ResponseEntity<List<Reseña>> getUsuarios() {
        return ResponseEntity.ok().body(reseñaService.listar());
    }
    @PostMapping("/agregar")
       public ResponseEntity<Reseña> agregarReseña(@RequestBody@valid ReseñaDTO reseñaDTO){
        Response response = null;
        Cliente cliente = clienteService.get(reseñaDTO.getCliente_cedula());
        Libro libro = libroService.get(reseñaDTO.getLibro_id());
        Reseña reseña = Reseña.builder()
        .descripcion(reseñaDTO.getDescripcion())
        .titulo(reseñaDTO.getTitulo())
        .cliente(cliente)
        .libro(libro)
        .build();
        try {
           reseñaService.agregar(reseña);      
           
        } catch (NoSuchElementException e) {
          response = new Response(true, e.getMessage());
            Autor ww = new Autor();   
        
        }
       return ResponseEntity.ok(reseña);
    }

}
