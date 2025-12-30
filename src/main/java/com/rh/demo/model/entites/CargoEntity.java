package com.rh.demo.model.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cargo_registro")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"id"})
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
}
