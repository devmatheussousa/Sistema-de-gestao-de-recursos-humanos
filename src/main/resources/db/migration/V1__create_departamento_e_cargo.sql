CREATE TABLE tb_departamento_registro (
                                          id BIGSERIAL PRIMARY KEY,
                                          nome_departamento VARCHAR(50) NOT NULL,
                                          descricao_departamento VARCHAR(200) NOT NULL
);

CREATE TABLE tb_cargo_registro (
                                   id BIGSERIAL PRIMARY KEY,
                                   nome_cargo VARCHAR(50) NOT NULL,
                                   descricao_cargo VARCHAR(200) NOT NULL,
                                   nivel_cargo VARCHAR(50) NOT NULL,
                                   salario_cargo DOUBLE PRECISION NOT NULL
);
