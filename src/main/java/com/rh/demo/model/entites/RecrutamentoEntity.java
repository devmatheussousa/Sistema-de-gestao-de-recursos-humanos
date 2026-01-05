package com.rh.demo.model.entites;

import com.rh.demo.enums.StatusRecrutamento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_recrutamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RecrutamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // ================= RELACIONAMENTOS =================
    // 1 Recrutamento -> cargo
    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private CargoEntity cargo;


    // 2 Recrutamento -> candidatos
    @OneToMany(mappedBy = "recrutamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidatoEntity> candidatos = new ArrayList<>();


    // 3 Recrutamento -> entrevistas
    @OneToMany(mappedBy = "recrutamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntrevistaEntity> entrevistas = new ArrayList<>();
}
