package com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.servicios;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia.RepositorioCrearFondo;

import java.util.List;
import java.util.Optional;

public class ServiciosCrearFondo {

    private final RepositorioCrearFondo repositorioCrearFondo;

    public ServiciosCrearFondo(RepositorioCrearFondo repositorioCrearFondo) {
        this.repositorioCrearFondo = repositorioCrearFondo;
    }

    public Optional<Boolean> crearFondo(Fondos fondo) {

        if (fondo.getMontoMinimo() < 500000) {
            return Optional.of(Boolean.FALSE);
        }

        return repositorioCrearFondo.guardar(fondo);
    }

    public Optional<List<Fondos>> consultar() {
        return repositorioCrearFondo.consultarTodos();
    }

    public Optional<Fondos> consultarXId(Integer id ) {
        return repositorioCrearFondo.consultarXId(id);
    }
}
