package com.acm.bibliotecafinal.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    boolean error;
    Object body;
}
