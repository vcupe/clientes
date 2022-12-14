DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente
(
id serial PRIMARY KEY, 
nombres VARCHAR(255), 
apellidos VARCHAR(255),
direccion VARCHAR(255),
email VARCHAR(100),
celular VARCHAR(20)
);