package com.rh.demo.model.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "folha_pagamento_funcionario")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"funcionario"})
public class FolhaPagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mes_ano_folha_pagamento", nullable = false)
    private LocalDate mesAno;

    @Column(name = "salario_bruto_folha_pagamento", nullable = false)
    private Double salarioBruto;
    
    @Column(name = "descontos_folha_pagamento", nullable = false)
    private Double descontos;

    @Column(name = "beneficios_folha_pagamento", length = 200, nullable = false)
    private String beneficios;

    @Column(name = "salario_liquido_folha_pagamento", nullable = false)
    private Double salarioLiquido;

    @Column(name = "data_pagamento_folha_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionarioEntity funcionario;
}
