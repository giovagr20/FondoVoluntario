package com.co.fondovoluntario.FondosVoluntarios.infraestructura.servicios;

import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.dto.DtoFondo;
import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.manejador.ManejadorFondos;
import org.springframework.stereotype.Service;

@Service
public class ServicioFondosFPV {
    private final ManejadorFondos manejadorFondos;

    public ServicioFondosFPV(ManejadorFondos manejadorFondos) {
        this.manejadorFondos = manejadorFondos;
    }

    public Boolean crearFondo(DtoFondo fondo) {
        return manejadorFondos.crearFondo(fondo).orElse(null);
    }
}
