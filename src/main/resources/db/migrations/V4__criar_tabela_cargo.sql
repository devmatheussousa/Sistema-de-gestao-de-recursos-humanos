CREATE SEQUENCE IF NOT EXISTS tb_cargo_registro_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE tb_cargo_registro
(
    id              BIGINT           NOT NULL,
    nome_cargo      VARCHAR(50)      NOT NULL,
    descricao_cargo VARCHAR(200)     NOT NULL,
    nivel_cargo     VARCHAR(50)      NOT NULL,
    salario_cargo   DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_tb_cargo_registro PRIMARY KEY (id)
);

CREATE TABLE tb_cargo_treinamento
(
    cargo_id       BIGINT NOT NULL,
    treinamento_id BIGINT NOT NULL
);

ALTER TABLE tb_cargo_treinamento
    ADD CONSTRAINT fk_tbcartre_on_cargo_entity FOREIGN KEY (cargo_id) REFERENCES tb_cargo_registro (id);

ALTER TABLE tb_cargo_treinamento
    ADD CONSTRAINT fk_tbcartre_on_treinamento_entity FOREIGN KEY (treinamento_id) REFERENCES tb_treinamento_candidato (id);