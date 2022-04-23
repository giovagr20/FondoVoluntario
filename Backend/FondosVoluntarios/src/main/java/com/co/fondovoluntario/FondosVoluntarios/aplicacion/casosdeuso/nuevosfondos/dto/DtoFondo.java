package com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DtoFondo {
    private String nombreFondo;
    private Long montoMinimo;
    private String categoria;
}
