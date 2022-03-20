package com.co.fondovoluntario.FondosVoluntarios.infraestructura.rest;

import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.dto.DtoFondo;
import com.co.fondovoluntario.FondosVoluntarios.infraestructura.servicios.ServicioFondosFPV;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/fpv")
@Tag(name = "Controlador encargado de realizar las transacciones del fondo")
public class RestFondosFPV {

    private final ServicioFondosFPV servicioFondosFPV;

    public RestFondosFPV(ServicioFondosFPV servicioFondosFPV) {
        this.servicioFondosFPV = servicioFondosFPV;
    }

    @Operation(summary = "Rest para suscribirse a un nuevo fondo")
    @PostMapping(value = "/suscribirse")
    public ResponseEntity<Boolean> crearFondo(@RequestBody DtoFondo fondo) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servicioFondosFPV.crearFondo(fondo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Boolean.FALSE);
        }
    }
}
