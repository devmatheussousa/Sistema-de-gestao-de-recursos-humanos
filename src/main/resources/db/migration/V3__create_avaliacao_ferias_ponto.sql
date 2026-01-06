CREATE TABLE IF NOT EXISTS tb_avaliacao (
                              id BIGSERIAL PRIMARY KEY,
                              data_avaliacao DATE NOT NULL,
                              nota_avaliacao INTEGER NOT NULL,
                              feedback_avaliacao VARCHAR(255),
                              funcionario_id BIGINT NOT NULL,

                              CONSTRAINT fk_avaliacao_funcionario
                                  FOREIGN KEY (funcionario_id)
                                      REFERENCES tb_funcionario_registro(id)
);

CREATE TABLE IF NOT EXISTS tb_ferias_funcionario (
                                       id BIGSERIAL PRIMARY KEY,
                                       data_inicio_ferias DATE NOT NULL,
                                       data_fim_ferias DATE NOT NULL,
                                       dias_ferias INTEGER NOT NULL,
                                       status_ferias VARCHAR(50) NOT NULL,
                                       funcionario_id BIGINT,

                                       CONSTRAINT fk_ferias_funcionario
                                           FOREIGN KEY (funcionario_id)
                                               REFERENCES tb_funcionario_registro(id)
);

CREATE TABLE IF NOT EXISTS tb_pontos_registro (
                                    id BIGSERIAL PRIMARY KEY,
                                    data DATE,
                                    hora_entrada TIMESTAMP,
                                    hora_saida TIMESTAMP,
                                    horas_trabalhadas TIME,
                                    tipo_ponto VARCHAR(50) NOT NULL,
                                    funcionario_id BIGINT,

                                    CONSTRAINT fk_ponto_funcionario
                                        FOREIGN KEY (funcionario_id)
                                            REFERENCES tb_funcionario_registro(id)
);
