CREATE SEQUENCE IF NOT EXISTS tb_candidato_registration_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE tb_candidato_registration
(
    id                 BIGINT NOT NULL,
    nome_candidato     VARCHAR(255),
    email_candidato    VARCHAR(255),
    telefone_candidato VARCHAR(255),
    curriculo_url      VARCHAR(255),
    status_candidato   VARCHAR(255),
    recrutamento_id    BIGINT NOT NULL,
    CONSTRAINT pk_tb_candidato_registration PRIMARY KEY (id)
);

ALTER TABLE tb_candidato_registration
    ADD CONSTRAINT FK_TB_CANDIDATO_REGISTRATION_ON_RECRUTAMENTO FOREIGN KEY (recrutamento_id) REFERENCES tb_recrutamento (id);