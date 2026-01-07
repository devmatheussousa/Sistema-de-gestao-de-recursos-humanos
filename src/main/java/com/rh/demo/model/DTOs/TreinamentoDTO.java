package com.rh.demo.model.DTOs;

import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

public record TreinamentoDTO(
        Long id,
        @NonNull
        String nomeTreinamento,
        @NonNull
        String descricaoTreinamento,
        @NonNull
        Integer cargaHoraria,
        @NonNull
        LocalDate dataInicio,
        @NonNull
        LocalDate dataFimTreinamento,
        List<Long> funcionarioIds,
        List<Long> cargoIds
) {
}
