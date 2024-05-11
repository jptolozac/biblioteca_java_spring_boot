package com.acm.bibliotecafinal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDTO {
    @NotBlank
    String cedula;
    @NotBlank
    String contraseña;
}
