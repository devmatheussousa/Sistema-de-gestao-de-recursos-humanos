package com.rh.demo.model.entites;

import com.rh.demo.enums.TipoEntrevista;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_entrevista_recrutamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EntrevistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_entrevista")
    private LocalDate dataEntrevista;

    @Enumerated(EnumType.STRING) // para persistir o enum como string no banco de dados
    @Column(name = "tipo_entrevista")
    private TipoEntrevista tipoEntrevista;

    @Column(name = "resultado_entrevista", nullable = false, length = 100) // resultado da entrevista (aprovado, reprovado, etc.)
    private String resultadoEntrevista;

    @Column(name = "observacoes_entrevista", length = 255) // observações adicionais sobre a entrevista
    private String observacoesEntrevista;

    // ================= RELACIONAMENTOS =================
    // 1 Entrevista -> recrutamento
    @ManyToOne
    @JoinColumn(name = "recrutamento_id", nullable = false)
    private RecrutamentoEntity recrutamento;

    @ManyToMany
    @JoinTable(
                name = "tb_entrevista_candidato",
                joinColumns = @JoinColumn(name = "entrevista_id"),
                inverseJoinColumns = @JoinColumn(name = "candidato_id")
    )
    private List<CandidatoEntity> candidatos = new ArrayList<>();
}
