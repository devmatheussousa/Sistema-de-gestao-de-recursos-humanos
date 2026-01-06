package com.rh.demo.model.entites;

import com.rh.demo.enums.TipoBeneficio;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_beneficios_registros")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BeneficioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beneficio_seq")
    @SequenceGenerator(
            name = "beneficio_seq",
            sequenceName = "tb_beneficios_registros_seq",
            allocationSize = 1 // ⚠️ TEM que bater com o banco
    )
    private Long id;


    @Column(name = "nome_beneficio")
    private String nome;

    @Column(name = "descricao_beneficio")
    private String descricao;

    @Column(name = "valor_beneficio")
    private Double valor;

    @Column(name = "tipo_beneficio")
    @Enumerated(EnumType.STRING)
    private TipoBeneficio tipoBeneficio;

    @ManyToMany
    @JoinTable(
            name = "beneficio_funcionario",
            joinColumns = @JoinColumn(name = "beneficio_id"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id") // relacionamento bidirecional
    )
    @ToString.Exclude
    private List<FuncionarioEntity> funcionarios = new ArrayList<>();
}
