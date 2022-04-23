package com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;

import java.util.Optional;

public interface RepositorioCrearFondo {

    Optional<Boolean> guardar(Fondos fondo);

    Optional<Boolean> eliminar(Long id);
}
