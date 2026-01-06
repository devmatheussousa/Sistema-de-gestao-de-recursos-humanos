package com.rh.demo.model.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_departamento_registro")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_departamento", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao_departamento", length = 200, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "departamento")
    @JsonIgnore // evita recursividade infinita
    @ToString.Exclude
    private List<FuncionarioEntity> funcionarios;
}
