CREATE TABLE IF NOT EXISTS tb_beneficios_registros (
                                         id BIGINT PRIMARY KEY DEFAULT nextval('tb_beneficios_registros_seq'),
                                         nome_beneficio VARCHAR(255),
                                         descricao_beneficio VARCHAR(255),
                                         valor_beneficio DOUBLE PRECISION,
                                         tipo_beneficio VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS beneficio_funcionario (
                                       beneficio_id BIGINT NOT NULL,
                                       funcionario_id BIGINT NOT NULL,

                                       CONSTRAINT pk_beneficio_funcionario
                                           PRIMARY KEY (beneficio_id, funcionario_id),

                                       CONSTRAINT fk_beneficio_funcionario_beneficio
                                           FOREIGN KEY (beneficio_id)
                                               REFERENCES tb_beneficios_registros(id),

                                       CONSTRAINT fk_beneficio_funcionario_funcionario
                                           FOREIGN KEY (funcionario_id)
                                               REFERENCES tb_funcionario_registro(id)
);
