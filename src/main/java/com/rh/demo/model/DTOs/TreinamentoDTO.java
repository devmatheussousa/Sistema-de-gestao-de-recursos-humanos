package com.rh.demo.model.DTOs;

import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

public record TreinamentoDTO(
        Long id,
        @NotNull
        String nomeTreinamento,
        @NotNull
        String descricaoTreinamento,
        @NotNull
        Integer cargaHoraria,
        @NotNull
        LocalDate dataInicio,
        @NotNull
        LocalDate dataFimTreinamento,

        List<Long> funcionarioIds,
        List<Long> cargoIds
) {
}
