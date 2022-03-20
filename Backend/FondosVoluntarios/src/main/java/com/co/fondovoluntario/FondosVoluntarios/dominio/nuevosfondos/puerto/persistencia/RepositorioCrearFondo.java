package com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCrearFondo extends CrudRepository<Fondos, Long> {

    Boolean guardar (Fondos fondos);

    Boolean eliminar(Long id);

}
