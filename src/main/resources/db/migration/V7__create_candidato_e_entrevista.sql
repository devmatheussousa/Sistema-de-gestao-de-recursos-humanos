CREATE TABLE IF NOT EXISTS tb_candidato_registration (
                                           id BIGSERIAL PRIMARY KEY,
                                           nome_candidato VARCHAR(255),
                                           email_candidato VARCHAR(255),
                                           telefone_candidato VARCHAR(255),
                                           curriculo_url VARCHAR(255),
                                           status_candidato VARCHAR(50),
                                           recrutamento_id BIGINT NOT NULL,

                                           CONSTRAINT fk_candidato_recrutamento
                                               FOREIGN KEY (recrutamento_id)
                                                   REFERENCES tb_recrutamento(id)
);

CREATE TABLE IF NOT EXISTS tb_entrevista_recrutamento (
                                            id BIGSERIAL PRIMARY KEY,
                                            data_entrevista DATE,
                                            tipo_entrevista VARCHAR(50),
                                            resultado_entrevista VARCHAR(100) NOT NULL,
                                            observacoes_entrevista VARCHAR(255),
                                            recrutamento_id BIGINT NOT NULL,

                                            CONSTRAINT fk_entrevista_recrutamento
                                                FOREIGN KEY (recrutamento_id)
                                                    REFERENCES tb_recrutamento(id)
);

CREATE TABLE IF NOT EXISTS tb_entrevista_candidato (
                                         entrevista_id BIGINT NOT NULL,
                                         candidato_id BIGINT NOT NULL,

                                         PRIMARY KEY (entrevista_id, candidato_id),

                                         CONSTRAINT fk_entrevista_candidato_entrevista
                                             FOREIGN KEY (entrevista_id)
                                                 REFERENCES tb_entrevista_recrutamento(id),

                                         CONSTRAINT fk_entrevista_candidato_candidato
                                             FOREIGN KEY (candidato_id)
                                                 REFERENCES tb_candidato_registration(id)
);
