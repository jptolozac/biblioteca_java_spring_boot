package com.acm.bibliotecafinal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReseñaDTO {
    @NotBlank
    String descripcion;
    @NotBlank
    String titulo;
    @NotBlank
    String cliente_cedula;
    @NotBlank
    int libro_id;
    
}
