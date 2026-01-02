package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusCandidato;
import com.rh.demo.model.entites.EntrevistaEntity;
import com.rh.demo.model.entites.RecrutamentoEntity;

import java.util.List;

public record CandidatoDTO(
        Long id,
        String nomeCandidato,
        String emailCandidato,
        String telefoneCandidato,
        String curriculoUrl,
        StatusCandidato statusCandidato,
        RecrutamentoEntity recrutamento,
        List<Long> entrevistaIds
) {
}
