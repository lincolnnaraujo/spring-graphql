DROP TABLE if exists cliente;

CREATE TABLE cliente(
    id UUID PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cep VARCHAR(8) NOT NULL
);