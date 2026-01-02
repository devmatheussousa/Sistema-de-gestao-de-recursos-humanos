package com.rh.demo.model.DTOs;

import java.time.LocalDate;
import java.util.List;

public record EntrevistaDTO(
        Long id,
        LocalDate dataEntrevista,
        String tipoEntrevista,
        String resultadoEntrevista,
        String observacoesEntrevista,
        Long recrutamentoId,
        List<Long> candidatosIds
) {
}
