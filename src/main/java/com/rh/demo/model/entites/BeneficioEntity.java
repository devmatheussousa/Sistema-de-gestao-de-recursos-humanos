package com.rh.demo.model.entites;

import com.rh.demo.enums.TipoBeneficio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_beneficios_registros")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id"})
public class BeneficioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
