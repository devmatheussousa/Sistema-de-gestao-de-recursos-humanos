CREATE SEQUENCE IF NOT EXISTS tb_departamento_registro_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE tb_departamento_registro
(
    id                     BIGINT       NOT NULL,
    nome_departamento      VARCHAR(50)  NOT NULL,
    descricao_departamento VARCHAR(200) NOT NULL,
    CONSTRAINT pk_tb_departamento_registro PRIMARY KEY (id)
);