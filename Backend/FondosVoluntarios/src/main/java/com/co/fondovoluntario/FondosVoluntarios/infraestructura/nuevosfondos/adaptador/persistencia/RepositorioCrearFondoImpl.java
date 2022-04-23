package com.co.fondovoluntario.FondosVoluntarios.infraestructura.nuevosfondos.adaptador.persistencia;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia.RepositorioCrearFondo;
import com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.jdbc.custom.CustomJdbcTemplate;
import com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;
import java.util.Optional;

public class RepositorioCrearFondoImpl implements RepositorioCrearFondo {

    private final CustomJdbcTemplate customJdbcTemplate;

    @SqlStatement(namespace = "nuevosfondos", value = "guardar")
    private String sqlGuardar;
    @SqlStatement(namespace = "nuevosfondos", value = "eliminar")
    private String sqlEliminar;

    public RepositorioCrearFondoImpl(CustomJdbcTemplate customJdbcTemplate) {
        this.customJdbcTemplate = customJdbcTemplate;
    }

    @Override
    public Optional<Boolean> guardar(Fondos fondo) {
        SqlParameterSource parametros = new MapSqlParameterSource()
                .addValue("nombre_fondo", fondo.getNombreFondo())
                .addValue("monto", fondo.getMontoMinimo())
                .addValue("categoria", fondo.getCategoria());
        Optional<Long> id = customJdbcTemplate.save(sqlGuardar, parametros, "id");

        if (id.isEmpty()) {
            return Optional.of(Boolean.FALSE);
        }
        return Optional.of(Boolean.TRUE);
    }

    @Override
    public Optional<Fondos> consultarXId(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Fondos>> consultarTodos() {
        return Optional.empty();
    }
}
