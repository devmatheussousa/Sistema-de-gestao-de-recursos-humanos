package com.rh.demo.model.entites;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_avaliacao")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "funcionario")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDate dataAvaliacao;

    @Column(name = "nota_avaliacao", nullable = false)
    private Integer notaAvaliacao;

    @Column(name = "feedback_avaliacao", length = 255)
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionarioEntity funcionario;
}
