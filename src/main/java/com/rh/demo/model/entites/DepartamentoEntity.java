package com.rh.demo.model.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_departamento_registro")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"id"})
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_departamento", length = 50, nullable = false)
    private String nome;

    @Column(name = "descricao_departamento", length = 200, nullable = false)
    private String descricao;
}
