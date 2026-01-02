package com.rh.demo.model.DTOs;

import java.time.LocalDate;
import java.util.List;

public record TreinamentoDTO(
        Long id,
        String nomeTreinamento,
        String descricaoTreinamento,
        Integer cargaHoraria,
        LocalDate dataInicio,
        LocalDate dataFimTreinamento,
        List<Long> funcionarioIds,
        List<Long> cargoIds
) {
}
