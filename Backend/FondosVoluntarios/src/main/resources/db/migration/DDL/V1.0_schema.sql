CREATE SCHEMA IF NOT EXISTS fondosvoluntarios;

CREATE TABLE IF NOT EXISTS fondosvoluntarios.fondos(
    id SERIAL,
    nombre_fondo VARCHAR(200),
    monto INTEGER,
    categoria VARCHAR(100),
    PRIMARY KEY (id)
)