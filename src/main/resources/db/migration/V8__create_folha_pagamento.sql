CREATE TABLE IF NOT EXISTS folha_pagamento_funcionario (
                                             id BIGSERIAL PRIMARY KEY,
                                             mes_ano_folha_pagamento DATE NOT NULL,
                                             salario_bruto_folha_pagamento DOUBLE PRECISION NOT NULL,
                                             descontos_folha_pagamento DOUBLE PRECISION NOT NULL,
                                             beneficios_folha_pagamento VARCHAR(200) NOT NULL,
                                             salario_liquido_folha_pagamento DOUBLE PRECISION NOT NULL,
                                             data_pagamento_folha_pagamento DATE NOT NULL,
                                             funcionario_id BIGINT NOT NULL,

                                             CONSTRAINT fk_folha_pagamento_funcionario
                                                 FOREIGN KEY (funcionario_id)
                                                     REFERENCES tb_funcionario_registro(id)
);
