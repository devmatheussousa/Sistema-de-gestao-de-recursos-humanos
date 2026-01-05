package com.rh.demo.model.entites;

import com.rh.demo.enums.StatusFerias;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_ferias_funcionario")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class FeriasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_inicio_ferias", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim_ferias", nullable = false)
    private Double dataFim;

    @Column(name = "dias_ferias", nullable = false)
    private Integer dias;

    @Column(name = "status_ferias", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusFerias statusFerias;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioEntity funcionario;
}
