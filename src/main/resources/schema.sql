DROP TABLE if exists compra;
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
    valor DECIMAL(18,2) NOT NULL,
    quantidade int NOT NULL
);

CREATE TABLE compra(
    id UUID PRIMARY KEY,
    data DATETIME NOT NULL,
    valor DECIMAL(18,2) NOT NULL,
    status CHAR(5) NOT NULL,
    cliente_id UUID NOT NULL,
    produto_id UUID NOT NULL
);

ALTER TABLE compra ADD CONSTRAINT const_compra_001 FOREIGN KEY (cliente_id) REFERENCES cliente (id);
ALTER TABLE compra ADD CONSTRAINT const_compra_002 FOREIGN KEY (produto_id) REFERENCES produto (id);