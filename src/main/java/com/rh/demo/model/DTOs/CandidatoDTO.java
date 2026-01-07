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
        @NotNull RecrutamentoEntity recrutamento,
        @NotNull @Size(min = 1) List<@NotNull Long> entrevistaIds
) {
}
