package com.co.fondovoluntario.FondosVoluntarios.infraestructura.nuevosfondos.adaptador.persistencia;

import com.co.fondovoluntario.FondosVoluntarios.dominio.nuevosfondos.modelo.Fondos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FondosRowMapper implements RowMapper<Fondos> {
    @Override
    public Fondos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fondos fondos = new Fondos();

        fondos.setNombreFondo(rs.getString("nombre_fondo"));
        fondos.setCategoria(rs.getString("categoria"));
        fondos.setMontoMinimo(rs.getLong("monto"));

        return fondos;
    }
}
