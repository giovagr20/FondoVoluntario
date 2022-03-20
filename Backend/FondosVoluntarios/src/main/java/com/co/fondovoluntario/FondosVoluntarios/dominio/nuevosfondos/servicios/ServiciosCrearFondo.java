package com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.servicios;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia.RepositorioCrearFondo;

import java.util.Optional;

public class ServiciosCrearFondo {

    private final RepositorioCrearFondo repositorioCrearFondo;

    public ServiciosCrearFondo(RepositorioCrearFondo repositorioCrearFondo) {
        this.repositorioCrearFondo = repositorioCrearFondo;
    }

    public Optional<Boolean> crearFondo(Fondos fondo) {
        return Optional.of(Boolean.TRUE);
    }
}
