package com.rh.demo.model.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cargo_registro")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_cargo", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao_cargo", length = 200, nullable = false)
    private String descricao;

    @Column(name = "nivel_cargo", length = 50, nullable = false)
    private String nivel;

    @Column(name = "salario_cargo", nullable = false)
    private Double salario;

    @OneToOne(mappedBy = "cargo")
    private FuncionarioEntity funcionario;

    @ManyToMany
    @JoinTable(
            name = "tb_cargo_treinamento",
            joinColumns = @JoinColumn(name = "cargo_id"),
            inverseJoinColumns = @JoinColumn(name = "treinamento_id")
    )
    private List<TreinamentoEntity> treinamentos = new ArrayList<>();

    @OneToMany(mappedBy = "cargo")
    private List<RecrutamentoEntity> recrutamentos = new ArrayList<>();
}
