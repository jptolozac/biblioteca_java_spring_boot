package com.acm.bibliotecafinal.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acm.bibliotecafinal.dto.PrestamoDTO;
import com.acm.bibliotecafinal.dto.Response;
import com.acm.bibliotecafinal.models.Cliente;
import com.acm.bibliotecafinal.models.Libro;
import com.acm.bibliotecafinal.models.Multa;
import com.acm.bibliotecafinal.models.Prestamo;
import com.acm.bibliotecafinal.services.IClienteService;
import com.acm.bibliotecafinal.services.ILibroService;
import com.acm.bibliotecafinal.services.IMultaService;
import com.acm.bibliotecafinal.services.IPrestamoService;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;

@RestController
@Validated
@RequestMapping("/prestamos")
public class PrestamoController {
    @Autowired
    IPrestamoService prestamoService;
    @Autowired
    ILibroService libroService;
    @Autowired
    IClienteService clienteService;
    @Autowired
    IMultaService multaService;

    @PostMapping("")
    public ResponseEntity<Response> prueba(@RequestBody @Valid PrestamoDTO prestamo) {
        Response response = null;

        //validaciones para el cliente
        Cliente cliente = null;
        try {
            cliente = clienteService.get(prestamo.getCliente_cedula());
            if (cliente.getEstadoCuenta().equals("inactivo")) {
                response = new Response(true, "cliente inactivo");
                return ResponseEntity.badRequest().body(response);
            }
            List<Multa> multas = cliente.getMultas();
            for (Multa multa : multas) {
                if (multa.isEstado()) {
                    response = new Response(true, "cliente Multado");
                    return ResponseEntity.badRequest().body(response);
                }
            }
        } catch (NoSuchElementException e) {
            response = new Response(true, "cliente no encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        
        //validaciones para los libros
        Libro[] libros = new Libro[prestamo.getLibros_id().length];
        for(int i=0; i<libros.length; i++){
            try {
                libros[i] = libroService.get(prestamo.getLibros_id()[i]);
            } catch (NoSuchElementException e) {
                response = new Response(false, "El libro " + i+1 + " de la lista no se encuentra");
                return ResponseEntity.badRequest().body(response);
            }
            if (libros[i].getDisponibilidad() < 1) {
                response = new Response(true, "El libro con id " + libros[i].getId() + " no tiene disponibilidad");
                return ResponseEntity.badRequest().body(response);
            }
        }

        //Prestamo de los libros
        for(Libro libro : libros){
            Prestamo prestamoModel = Prestamo.builder()
                    .cliente(cliente)
                    .libro(libro)
                    .fechaInicio(LocalDate.now())
                    .fechaFin(prestamo.getFecha_fin())
                    .build();
            try {
                prestamoService.agregar(prestamoModel);
                libro.setDisponibilidad(libro.getDisponibilidad() - 1);
                libroService.actualizar(libro);
            } catch (Exception e) {
                response = new Response(true, "El libro con id " + libro.getId() + " no se pudo reservar");
                return ResponseEntity.internalServerError().body(response);
            }
        }
        
        response = new Response(false, "Libros reservados");
        return ResponseEntity.ok(response);
    }
}
