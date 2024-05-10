package com.acm.bibliotecafinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    @NotBlank
    String cedula;
    @NotBlank
    String nombre;
    @Email
    String correo;
    @NotBlank
    String contraseña;
    @NotBlank
    String telefono;
    @NotBlank
    String rol;
}
