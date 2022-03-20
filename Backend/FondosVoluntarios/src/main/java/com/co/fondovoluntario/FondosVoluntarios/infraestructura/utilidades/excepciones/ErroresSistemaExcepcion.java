package com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.excepciones;

public class ErroresSistemaExcepcion extends RuntimeException{

    private static final long serialVersionUID = -4007710581840298528L;

    public ErroresSistemaExcepcion(String message) {
        super(message);
    }
}
