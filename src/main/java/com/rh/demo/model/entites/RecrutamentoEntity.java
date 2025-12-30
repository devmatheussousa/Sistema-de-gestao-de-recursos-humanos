package com.rh.demo.model.entites;

import com.rh.demo.enums.StatusRecrutamento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_recrutamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"id"})
public class RecrutamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recrutamento")
    private Long id;

    @Column(name = "titulo_vaga")
    private String tituloVaga;

    @Column(name = "descricao_vaga")
    private String descricaoVaga;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "data_encerramento")
    private LocalDateTime dataEncerramento;

    @Enumerated(EnumType.STRING) // para persistir o enum como string no banco de dados
    @Column(name = "status_recrutamento")
    private StatusRecrutamento statusRecrutamento;


}
