package com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo;

public class Fondos {
    private String nombreFondo;
    private Long montoMinimo;
    private String categoria;

    public Fondos() {
    }

    public Fondos(String nombreFondo, Long montoMinimo, String categoria) {
        this.nombreFondo = nombreFondo;
        this.montoMinimo = montoMinimo;
        this.categoria = categoria;
    }

    public String getNombreFondo() {
        return nombreFondo;
    }

    public void setNombreFondo(String nombreFondo) {
        this.nombreFondo = nombreFondo;
    }

    public Long getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(Long montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
