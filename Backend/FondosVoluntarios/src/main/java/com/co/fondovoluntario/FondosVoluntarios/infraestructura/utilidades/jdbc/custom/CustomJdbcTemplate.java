package com.co.fondovoluntario.FondosVoluntarios.infraestructura.utilidades.jdbc.custom;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomJdbcTemplate {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Long> save(String sql, SqlParameterSource parametros, String nombreIdTabla) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, parametros, keyHolder, new String[]{nombreIdTabla});

        Number idRegistroCreado = keyHolder.getKey();
        if (idRegistroCreado == null) {
            return Optional.empty();
        }

        return Optional.of(idRegistroCreado.longValue());
    }

    public boolean update(String sql, SqlParameterSource parametros) {
        int cantidadActualizados = jdbcTemplate.update(sql, parametros);

        return cantidadActualizados == 1;
    }

    public <T> Optional<T> findOne(String sql, SqlParameterSource parametros, RowMapper<T> mapper) {
        List<T> lista = jdbcTemplate.query(sql, parametros, mapper);
        if (lista.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(lista.get(0));
    }

    public boolean exist(String sql, SqlParameterSource parametros) {
        Long cantidad = jdbcTemplate.queryForObject(sql, parametros, Long.class);
        if (cantidad == null) {
            return false;
        }

        return cantidad > 0;
    }

    public <T> Optional<List<T>> listAll(String sql, RowMapper<T> mapper) {
        List<T> registros = jdbcTemplate.query(sql, mapper);
        if (registros.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(registros);
    }

    public <T> Optional<List<T>> listAll(String sql, SqlParameterSource parametros, RowMapper<T> mapper) {
        List<T> registros = jdbcTemplate.query(sql, parametros, mapper);
        if (registros.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(registros);
    }

    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
