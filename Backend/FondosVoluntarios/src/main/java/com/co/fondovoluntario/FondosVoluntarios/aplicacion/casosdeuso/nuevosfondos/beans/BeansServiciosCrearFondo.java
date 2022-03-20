package com.co.fondovoluntario.FondosVoluntarios.aplicacion.casosdeuso.nuevosfondos.beans;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia.RepositorioCrearFondo;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.servicios.ServiciosCrearFondo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansServiciosCrearFondo {

    @Bean
    public ServiciosCrearFondo serviciosCrearFondo(RepositorioCrearFondo repositorioCrearFondo) {
        return new ServiciosCrearFondo(repositorioCrearFondo);
    }
}
