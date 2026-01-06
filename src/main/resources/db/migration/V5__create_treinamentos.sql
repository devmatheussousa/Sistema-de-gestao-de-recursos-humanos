CREATE TABLE IF NOT EXISTS tb_treinamento_candidato (
                                          id BIGSERIAL PRIMARY KEY,
                                          nome_treinamento VARCHAR(255),
                                          descricao_treinamento VARCHAR(255),
                                          carga_horaria INTEGER NOT NULL,
                                          data_inicio_treinamento DATE NOT NULL,
                                          data_fim_treinamento DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS treinamento_funcionario (
                                         treinamento_id BIGINT NOT NULL,
                                         funcionario_id BIGINT NOT NULL,

                                         PRIMARY KEY (treinamento_id, funcionario_id),

                                         CONSTRAINT fk_treinamento_funcionario_treinamento
                                             FOREIGN KEY (treinamento_id)
                                                 REFERENCES tb_treinamento_candidato(id),

                                         CONSTRAINT fk_treinamento_funcionario_funcionario
                                             FOREIGN KEY (funcionario_id)
                                                 REFERENCES tb_funcionario_registro(id)
);

CREATE TABLE IF NOT EXISTS tb_cargo_treinamento (
                                      cargo_id BIGINT NOT NULL,
                                      treinamento_id BIGINT NOT NULL,

                                      PRIMARY KEY (cargo_id, treinamento_id),

                                      CONSTRAINT fk_cargo_treinamento_cargo
                                          FOREIGN KEY (cargo_id)
                                              REFERENCES tb_cargo_registro(id),

                                      CONSTRAINT fk_cargo_treinamento_treinamento
                                          FOREIGN KEY (treinamento_id)
                                              REFERENCES tb_treinamento_candidato(id)
);
