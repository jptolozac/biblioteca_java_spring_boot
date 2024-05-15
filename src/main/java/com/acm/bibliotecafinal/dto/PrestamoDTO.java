package com.acm.bibliotecafinal.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrestamoDTO {
    @NotBlank
    String cliente_cedula;
    @NotNull
    Integer[] libros_id;
    @NotNull
    LocalDate fecha_fin;
}
