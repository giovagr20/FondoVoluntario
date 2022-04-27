package com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.manejador;

import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.dto.DtoFondo;
import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.mapper.FondosMapper;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.servicios.ServiciosCrearFondo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ManejadorFondos {

    private final ServiciosCrearFondo serviciosCrearFondo;
    private final FondosMapper fondosMapper;

    public ManejadorFondos(ServiciosCrearFondo serviciosCrearFondo, FondosMapper fondosMapper) {
        this.serviciosCrearFondo = serviciosCrearFondo;
        this.fondosMapper = fondosMapper;
    }

    public Optional<Boolean> crearFondo(DtoFondo fondo) {
        return serviciosCrearFondo.crearFondo(Objects.requireNonNull(fondosMapper.dtoAModelo(fondo).orElse(null)));
    }

    public Optional<List<DtoFondo>> consultar() {
        return fondosMapper.listaModeloAListaDto(serviciosCrearFondo.consultar().orElse(null));
    }

    public Optional<DtoFondo> consultarXId(Integer id) {
        return fondosMapper.modeloADto(serviciosCrearFondo.consultarXId(id).orElse(null));
    }
}
