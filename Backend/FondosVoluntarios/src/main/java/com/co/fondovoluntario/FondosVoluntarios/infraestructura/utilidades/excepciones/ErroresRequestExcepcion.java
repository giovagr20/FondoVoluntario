package com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.excepciones;

public class ErroresRequestExcepcion extends RuntimeException {
    private static final long serialVersionUID = -400771058186798528L;

    public ErroresRequestExcepcion(String message) {
        super(message);
    }
}
