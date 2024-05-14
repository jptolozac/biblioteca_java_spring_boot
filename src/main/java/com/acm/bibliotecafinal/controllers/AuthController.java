package com.acm.bibliotecafinal.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bibliotecafinal.dto.ClienteDTO;
import com.acm.bibliotecafinal.dto.LibroDTO;
import com.acm.bibliotecafinal.models.Autor;
import com.acm.bibliotecafinal.models.Categoria;
import com.acm.bibliotecafinal.models.Cliente;
import com.acm.bibliotecafinal.models.Editorial;
import com.acm.bibliotecafinal.models.Libro;
import com.acm.bibliotecafinal.models.Prestamo;
import com.acm.bibliotecafinal.models.Reseña;
import com.acm.bibliotecafinal.models.Rol;
import com.acm.bibliotecafinal.models.RolEnum;
import com.acm.bibliotecafinal.services.IClienteService;
import com.acm.bibliotecafinal.services.ILibroService;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")

public class AuthController {
    @Autowired
    IClienteService clienteService;
    ILibroService   libroService;
    

    @GetMapping("login")
    public String login() {
        return "Logueado de un endpoint publico";
    }
    @PostMapping("agregarlibro")

       public ResponseEntity<Libro> agregarlibro(@RequestBody@valid LibroDTO libroDTO){
        Autor autor = new Autor();
        Categoria categoria = new Categoria();
        Editorial editorial =new Editorial("ww","wq");
        List prestamos = new Prestamo();
        
        Libro libro = Libro.builder()   
        .añoPublicacion(libroDTO.getAñoPublicacion())
        .disponibilidad(libroDTO.getDisponibilidad())
        .titulo(libroDTO.getTitulo())
        .autor(autor)
        .categoria(categoria)
        .editorial(editorial)
        .prestamos(prestamos)
        .reseñas(null)
        .build();
        libroService.agregar(libro);
        return ResponseEntity.ok(libro);
        }
    
    @GetMapping("reseña")
    public String reseña() {
        return "Logueado de un endpoint publico";
    }
    @PostMapping("register")
    public ResponseEntity<Cliente> register(@RequestBody@Valid ClienteDTO clienteDTO) {
        Cliente cliente = Cliente.builder()
            .cedula(clienteDTO.getCedula())
            .nombre(clienteDTO.getNombre())
            .correo(clienteDTO.getCorreo())
            .telefono(clienteDTO.getTelefono())
            .contraseña(clienteDTO.getContraseña())
            .rol(new ArrayList<>())
            .estadoCuenta("activo")
            .build();

        cliente.getRol().add(Rol.builder().rol(RolEnum.valueOf(clienteDTO.getRol())).cliente(cliente).build());
        clienteService.agregar(cliente);

        return ResponseEntity.ok(cliente);
    }
}
