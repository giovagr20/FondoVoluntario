package com.co.fondovoluntario.FondosVoluntarios.infraestructura.nuevosfondos.rest;

import com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.dto.DtoFondo;
import com.co.fondovoluntario.FondosVoluntarios.infraestructura.nuevosfondos.servicios.ServicioFondosFPV;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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

    @Operation(summary = "Rest para obtener fondos")
    @GetMapping("consultar")
    public ResponseEntity<List<DtoFondo>> obtenerFondos() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servicioFondosFPV.consultar());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }

    @Operation(summary = "Rest para obtener un fondo especifico")
    @GetMapping("consultar/{id}")
    public ResponseEntity<DtoFondo> obtenerXId(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(servicioFondosFPV.consultarXId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
