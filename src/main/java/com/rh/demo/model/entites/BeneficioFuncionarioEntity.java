package com.rh.demo.model.entites;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_beneficios_funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficioFuncionarioEntity {

    @EmbeddedId
    private BeneficioFuncionarioId beneficioFuncionarioId;


    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY para carregar o funcionário apenas quando necessário
    @MapsId("funcionarioId")
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionarioEntity funcionarioEntity;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY para carregar o benefício apenas quando necessário
    @MapsId("beneficioId")
    @JoinColumn(name = "beneficio_id", nullable = false)
    private BeneficioEntity beneficioEntity;

    //Campos extras que justificam a entidade
    private LocalDate dataAdesao;
    private BigDecimal valorDesconto;
    private boolean ativo;

}
