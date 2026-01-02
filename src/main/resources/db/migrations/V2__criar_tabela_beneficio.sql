CREATE SEQUENCE IF NOT EXISTS tb_beneficios_registros_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE beneficio_funcionario
(
    beneficio_id   BIGINT NOT NULL,
    funcionario_id BIGINT NOT NULL
);

CREATE TABLE tb_beneficios_registros
(
    id                  BIGINT NOT NULL,
    nome_beneficio      VARCHAR(255),
    descricao_beneficio VARCHAR(255),
    valor_beneficio     DOUBLE PRECISION,
    tipo_beneficio      VARCHAR(255),
    CONSTRAINT pk_tb_beneficios_registros PRIMARY KEY (id)
);

ALTER TABLE beneficio_funcionario
    ADD CONSTRAINT fk_benfun_on_beneficio_entity FOREIGN KEY (beneficio_id) REFERENCES tb_beneficios_registros (id);

ALTER TABLE beneficio_funcionario
    ADD CONSTRAINT fk_benfun_on_funcionario_entity FOREIGN KEY (funcionario_id) REFERENCES tb_funcionario_registro (id);