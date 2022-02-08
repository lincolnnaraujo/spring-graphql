DROP TABLE if exists cliente;
DROP TABLE if exists produto;

CREATE TABLE cliente(
    id UUID PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cep VARCHAR(8) NOT NULL
);

CREATE TABLE produto(
    id UUID PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    valor NUMERIC(15,2) NOT NULL,
    quantidade int NOT NULL
);