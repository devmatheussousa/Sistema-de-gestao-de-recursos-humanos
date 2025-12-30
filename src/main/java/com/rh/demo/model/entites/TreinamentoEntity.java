package com.rh.demo.model.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_treinamento_candidato")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TreinamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_treinamento")
    private String nomeTreinamento;

    @Column(name = "descricao_treinamento", length = 255)
    private String descricaoTreinamento;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "data_inicio_treinamento", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim_treinamento", nullable = false)
    private LocalDate dataFimTreinamento;
}
