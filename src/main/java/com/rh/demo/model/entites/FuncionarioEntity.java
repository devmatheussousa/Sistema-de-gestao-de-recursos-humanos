package com.rh.demo.model.entites;

import com.rh.demo.enums.StatusFuncionario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_funcionario_registro")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"id"})
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_funcionario")
    private Long id;

    @Column(name = "nome_funcionario")
    private String nome;

    @Column(name = "cpf_funcionario", unique = true)
    private Long cpf;

    @Column(name = "telefone_funcionario", unique = true)
    private Long telefone;

    @Column(name = "email_funcionario", unique = true)
    private String email;

    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;

    @Column(name = "salario_base_funcionario")
    private Double salarioBase;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_funcionario")
    private StatusFuncionario status;

    //relacionamento

    @ManyToOne // muitos funcionarios para um departamento
    @JoinColumn(name = "departamento_id")
    DepartamentoEntity departamento;

    @OneToOne // um funcionario para um cargo
    @JoinColumn(name = "cargo_id")
    CargoEntity cargo;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL) // um funcionario para muitos pontos
    List<PontoEntity> ponto;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL) // um funcionario para muitas férias
    @ToString.Exclude // evita recursão infinita
    List<FeriasEntity> ferias;


}


