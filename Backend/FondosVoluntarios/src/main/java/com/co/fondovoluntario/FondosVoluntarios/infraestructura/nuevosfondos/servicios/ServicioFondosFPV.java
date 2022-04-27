package com.co.fondovoluntario.FondosVoluntarios.infraestructura.nuevosfondos.servicios;

import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.dto.DtoFondo;
import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.manejador.ManejadorFondos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioFondosFPV {
    private final ManejadorFondos manejadorFondos;

    public ServicioFondosFPV(ManejadorFondos manejadorFondos) {
        this.manejadorFondos = manejadorFondos;
    }

    public String crearFondo(DtoFondo fondo) {
        if (Boolean.TRUE.equals(manejadorFondos.crearFondo(fondo).orElse(null))) {
            return "Se ha guardado con éxito el registro.";
        }

        return "No se ha guardado el registro, por favor validar.";
    }

    public List<DtoFondo> consultar() {
        return manejadorFondos.consultar().orElse(null);
    }

    public DtoFondo consultarXId(Integer id) {
        return manejadorFondos.consultarXId(id).orElse(null);
    }
}
