package com.rh.demo.model.entites;

import com.rh.demo.enums.StatusCandidato;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_candidato_registration")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CandidatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_candidato")
    private String nomeCandidato;

    @Column(name = "email_candidato")
    private String emailCandidato;

    @Column(name = "telefone_candidato")
    private String telefoneCandidato;

    @Column(name = "curriculo_url")
    private String curriculoUrl;

    @Enumerated(EnumType.STRING) // para persistir o enum como string no banco de dados
    @Column(name = "status_candidato")
    private StatusCandidato statusCandidato;

    // ================= RELACIONAMENTOS =================
    // 1 Candidato -> recrutamento
    /**
     * ❌ Erro comum:
     * - Não definir nullable pode gerar inconsistência entre Entity e regra de negócio.
     * <p>
     * ✅ Correção:
     * - nullable = false deixa claro que todo candidato DEVE ter um recrutamento.
     */
    @ManyToOne
    @JoinColumn(name = "recrutamento_id")
    @ToString.Exclude
    private RecrutamentoEntity recrutamento;

    /**
     * ❌ Problema potencial:
     * - Nome da lista estava no singular ("entrevista"), o que confunde leitura.
     * <p>
     * ✅ Correção:
     * - Usar nome no plural para coleções.
     */

    @ManyToMany(mappedBy = "candidatos")
    @ToString.Exclude
    private List<EntrevistaEntity> entrevistas;
}
