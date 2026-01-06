CREATE TABLE IF NOT EXISTS tb_usuario_login (
                                  id BIGSERIAL PRIMARY KEY,
                                  login_username VARCHAR(255),
                                  login_password VARCHAR(255),
                                  login_tipo_usuario VARCHAR(255)
);
