CREATE SCHEMA IF NOT EXISTS fondosvoluntarios;

CREATE TABLE IF NOT EXISTS fondosvoluntarios.cliente (
id SERIAL,
nombre VARCHAR(200),
apellidos VARCHAR(200),
ciudad VARCHAR(100),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fondosvoluntarios.sucursal (
id SERIAL,
nombre VARCHAR(200),
ciudad VARCHAR(100),
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS fondosvoluntarios.producto (
id SERIAL,
nombre VARCHAR(200),
tipo_producto VARCHAR(100),
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fondosvoluntarios.inscripcion (
id SERIAL,
CONSTRAINT id_producto FOREIGN KEY (id) REFERENCES
fondosvoluntarios.producto (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT id_cliente FOREIGN KEY (id) REFERENCES
fondosvoluntarios.cliente (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fondosvoluntarios.disponibilidad (
id SERIAL,
CONSTRAINT id_sucursal FOREIGN KEY (id) REFERENCES
fondosvoluntarios.sucursal (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT id_producto FOREIGN KEY (id) REFERENCES
fondosvoluntarios.producto (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS fondosvoluntarios.visitan (
id SERIAL,
CONSTRAINT id_sucursal FOREIGN KEY (id) REFERENCES
fondosvoluntarios.sucursal (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT id_cliente FOREIGN KEY (id) REFERENCES
fondosvoluntarios.cliente (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
fecha_visita TIMESTAMP,
PRIMARY KEY (id)
);