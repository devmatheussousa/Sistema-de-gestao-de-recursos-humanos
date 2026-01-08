package com.rh.demo.model.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY)
            @JoinTable(
            name = "treinamento_funcionario",
            joinColumns = @JoinColumn(name = "treinamento_id"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    )
    @ToString.Exclude
    private List<FuncionarioEntity> funcionarios = new ArrayList<>();

    @ManyToMany(mappedBy = "treinamentos") // um treinamento pode ser para vários cargos
    @ToString.Exclude
    private List<CargoEntity> cargos = new ArrayList<>(); // treinamento pode ser para vários cargos
}
