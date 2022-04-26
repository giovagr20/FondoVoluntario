package com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.mapper;

import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.dto.DtoFondo;
import com.co.fondovoluntario.FondosVoluntarios.aplicacion.utilidades.MapperGeneral;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FondosMapper implements MapperGeneral<DtoFondo, Fondos> {

    @Override
    public Optional<Fondos> dtoAModelo(DtoFondo dto) {
        try {
            if (dto == null) {
                return Optional.empty();
            }

            return Optional.of(new Fondos(dto.getNombreFondo(),
                    dto.getMontoMinimo(),
                    dto.getCategoria()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<DtoFondo> modeloADto(Fondos modelo) {
        if (modelo == null) {
            return Optional.empty();
        }

        DtoFondo fondo = new DtoFondo();

        fondo.setNombreFondo(modelo.getNombreFondo());
        fondo.setMontoMinimo(modelo.getMontoMinimo());
        fondo.setCategoria(modelo.getCategoria());

        return Optional.of(fondo);
    }
}
