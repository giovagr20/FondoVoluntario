package com.co.fondovoluntario.FondosVoluntarios.infraestructura.adaptador.persistencia;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia.RepositorioCrearFondo;

import java.util.Optional;

public class RepositorioCrearFondoImpl implements RepositorioCrearFondo {

    @Override
    public Boolean guardar(Fondos fondos) {
        return null;
    }

    @Override
    public Boolean eliminar(Long id) {
        return null;
    }

    @Override
    public <S extends Fondos> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Fondos> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Fondos> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Fondos> findAll() {
        return null;
    }

    @Override
    public Iterable<Fondos> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Fondos entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Fondos> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
