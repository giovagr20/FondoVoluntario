package com.co.fondovoluntario.FondosVoluntarios.aplicacion.utilidades;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public interface MapperGeneral<D, M> {
    Optional<M> dtoAModelo(D dto);

    Optional<D> modeloADto(M modelo);

    default Optional<List<M>> listaDtoAListaModelo(List<D> listaDto) {
        if (listaDto == null) {
            return Optional.empty();
        }

        return Optional.of(listaDto
                .stream()
                .map(dto -> dtoAModelo(dto).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }

    default Optional<List<D>> listaModeloAListaDto(List<M> listaModelo) {
        if (listaModelo == null) {
            return Optional.empty();
        }

        return Optional.of(listaModelo
                .stream()
                .map(modelo -> modeloADto(modelo).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }
}
