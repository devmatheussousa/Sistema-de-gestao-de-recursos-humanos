package com.rh.demo.model.entites;

import com.rh.demo.enums.StatusCandidato;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_candidato_registration")
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
    @ManyToOne
    @JoinColumn(name = "recrutamento_id", nullable = false)
    private RecrutamentoEntity recrutamento;
}
