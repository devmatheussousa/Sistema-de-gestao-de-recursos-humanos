package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusRecrutamento;
import com.rh.demo.model.entites.CargoEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record RecrutamentoDTO(
        Long id,
        String tituloVaga,
        String descricaoVaga,
        LocalDate dataAbertura,
        LocalDateTime dataEncerramento,
        StatusRecrutamento statusRecrutamento,
        CargoEntity cargo,
        List<Long> candidatosIds,
        List<Long> entrevistasIds
) {
}
