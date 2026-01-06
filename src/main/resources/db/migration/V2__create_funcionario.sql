CREATE TABLE IF NOT EXISTS tb_funcionario_registro (
                                         id BIGSERIAL PRIMARY KEY,
                                         nome_funcionario VARCHAR(255),
                                         cpf_funcionario BIGINT UNIQUE,
                                         telefone_funcionario BIGINT UNIQUE,
                                         email_funcionario VARCHAR(255) UNIQUE,
                                         data_nascimento DATE,
                                         data_admissao DATE,
                                         salario_base_funcionario DOUBLE PRECISION,
                                         status_funcionario VARCHAR(50),

                                         departamento_id BIGINT,
                                         cargo_id BIGINT UNIQUE,

                                         CONSTRAINT fk_funcionario_departamento
                                             FOREIGN KEY (departamento_id)
                                                 REFERENCES tb_departamento_registro(id),

                                         CONSTRAINT fk_funcionario_cargo
                                             FOREIGN KEY (cargo_id)
                                                 REFERENCES tb_cargo_registro(id)
);
