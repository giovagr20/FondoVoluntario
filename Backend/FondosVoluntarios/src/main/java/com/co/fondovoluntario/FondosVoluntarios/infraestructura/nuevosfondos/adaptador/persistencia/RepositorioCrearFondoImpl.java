package com.co.fondovoluntario.FondosVoluntarios.infraestructura.nuevosfondos.adaptador.persistencia;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.puerto.persistencia.RepositorioCrearFondo;
import com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.jdbc.custom.CustomJdbcTemplate;
import com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCrearFondoImpl implements RepositorioCrearFondo {

    private final CustomJdbcTemplate customJdbcTemplate;

    @SqlStatement(namespace = "nuevosfondos", value = "guardar")
    private String sqlGuardar;
    @SqlStatement(namespace = "nuevosfondos", value = "eliminar")
    private String sqlEliminar;
    @SqlStatement(namespace = "nuevosfondos", value = "consultarXId")
    private String sqlConsultarXId;
    @SqlStatement(namespace = "nuevosfondos", value = "consultar")
    private String sqlConsultar;

    public RepositorioCrearFondoImpl(CustomJdbcTemplate customJdbcTemplate) {
        this.customJdbcTemplate = customJdbcTemplate;
    }

    @Override
    public Optional<Boolean> guardar(Fondos fondo) {
        SqlParameterSource parametros = new MapSqlParameterSource()
                .addValue("nombreFondo", fondo.getNombreFondo())
                .addValue("monto", fondo.getMontoMinimo())
                .addValue("categoria", fondo.getCategoria());
        Optional<Long> id = customJdbcTemplate.save(sqlGuardar, parametros, "id");

        if (id.isEmpty()) {
            return Optional.of(Boolean.FALSE);
        }
        return Optional.of(Boolean.TRUE);
    }

    @Override
    public Optional<Fondos> consultarXId(Integer id) {
        SqlParameterSource parametros = new MapSqlParameterSource()
                .addValue("id", id);
        Optional<Fondos> fondos = customJdbcTemplate.findOne(sqlConsultarXId, parametros, new FondosRowMapper());
        if (fondos.isEmpty()) {
            return Optional.empty();
        }

        return fondos;
    }

    @Override
    public Optional<List<Fondos>> consultarTodos() {
        return customJdbcTemplate.listAll(sqlConsultar, new FondosRowMapper());
    }
}
