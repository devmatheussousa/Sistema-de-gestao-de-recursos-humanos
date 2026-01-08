package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoEntrevista;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record EntrevistaDTO(
        Long id,
        @NotNull
        LocalDate dataEntrevista,
        @NotNull
        TipoEntrevista tipoEntrevista,
        @NotNull
        String resultadoEntrevista,
        @NotNull
        String observacoesEntrevista,
        @NotNull
        Long recrutamentoId,
        List<Long> candidatosIds
) {
}
