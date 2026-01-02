CREATE SEQUENCE IF NOT EXISTS tb_funcionario_registro_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE tb_funcionario_registro
(
    id                       BIGINT NOT NULL,
    nome_funcionario         VARCHAR(255),
    cpf_funcionario          BIGINT,
    telefone_funcionario     BIGINT,
    email_funcionario        VARCHAR(255),
    data_nascimento          date,
    data_admissao            date,
    salario_base_funcionario DOUBLE PRECISION,
    status_funcionario       VARCHAR(255),
    departamento_id          BIGINT,
    cargo_id                 BIGINT,
    CONSTRAINT pk_tb_funcionario_registro PRIMARY KEY (id)
);

ALTER TABLE tb_funcionario_registro
    ADD CONSTRAINT uc_tb_funcionario_registro_cargo UNIQUE (cargo_id);

ALTER TABLE tb_funcionario_registro
    ADD CONSTRAINT uc_tb_funcionario_registro_cpf_funcionario UNIQUE (cpf_funcionario);

ALTER TABLE tb_funcionario_registro
    ADD CONSTRAINT uc_tb_funcionario_registro_email_funcionario UNIQUE (email_funcionario);

ALTER TABLE tb_funcionario_registro
    ADD CONSTRAINT uc_tb_funcionario_registro_telefone_funcionario UNIQUE (telefone_funcionario);

ALTER TABLE tb_funcionario_registro
    ADD CONSTRAINT FK_TB_FUNCIONARIO_REGISTRO_ON_CARGO FOREIGN KEY (cargo_id) REFERENCES tb_cargo_registro (id);

ALTER TABLE tb_funcionario_registro
    ADD CONSTRAINT FK_TB_FUNCIONARIO_REGISTRO_ON_DEPARTAMENTO FOREIGN KEY (departamento_id) REFERENCES tb_departamento_registro (id);