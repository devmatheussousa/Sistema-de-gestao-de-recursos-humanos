CREATE TABLE IF NOT EXISTS tb_recrutamento (
                                 id BIGSERIAL PRIMARY KEY,
                                 titulo_vaga VARCHAR(255),
                                 descricao_vaga VARCHAR(255),
                                 data_abertura DATE,
                                 data_encerramento TIMESTAMP,
                                 status_recrutamento VARCHAR(50),
                                 cargo_id BIGINT NOT NULL,

                                 CONSTRAINT fk_recrutamento_cargo
                                     FOREIGN KEY (cargo_id)
                                         REFERENCES tb_cargo_registro(id)
);
