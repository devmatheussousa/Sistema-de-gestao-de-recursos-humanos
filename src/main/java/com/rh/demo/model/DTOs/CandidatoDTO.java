package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusCandidato;
import com.rh.demo.model.entites.RecrutamentoEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CandidatoDTO(
        Long id,
        @NotNull String nomeCandidato,
        @NotNull String emailCandidato,
        @NotNull String telefoneCandidato,
        String curriculoUrl,
        @NotNull StatusCandidato statusCandidato,
        @NotNull Long recrutamentoId, //❌ ERRO: DTO NÃO pode conter Entity (RecrutamentoEntity).Isso acopla API à camada de persistência. ✅ CORREÇÃO:Usar apenas o ID do relacionamento.
        @NotNull @Size(min = 1) List<@NotNull Long> entrevistaIds //❌ Antes estava correto conceitualmente, mas agora fica consistente com a remoção da Entity acima.
) {
}
