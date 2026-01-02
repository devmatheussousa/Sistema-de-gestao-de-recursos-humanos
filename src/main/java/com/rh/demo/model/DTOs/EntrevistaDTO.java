package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoEntrevista;

import java.time.LocalDate;
import java.util.List;

public record EntrevistaDTO(
        Long id,
        LocalDate dataEntrevista,
        TipoEntrevista tipoEntrevista,
        String resultadoEntrevista,
        String observacoesEntrevista,
        Long recrutamentoId,
        List<Long> candidatosIds
) {
}
