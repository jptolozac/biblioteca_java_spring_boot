package com.acm.bibliotecafinal.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDTO {
    @NotBlank
    String titulo;
    @NotBlank
    LocalDate añoPublicacion;
    @NotBlank
    int disponibilidad;
    @NotBlank
    String categoria;
    @NotBlank
    String autor;
    @NotBlank
    String editorial;
}
