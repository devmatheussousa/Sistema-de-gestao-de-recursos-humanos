package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoEntrevista;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

public record EntrevistaDTO(
        Long id,
        @NonNull
        LocalDate dataEntrevista,
        @NonNull
        TipoEntrevista tipoEntrevista,
        @NonNull
        String resultadoEntrevista,
        @NonNull
        String observacoesEntrevista,
        @NonNull
        Long recrutamentoId,
        List<Long> candidatosIds
) {
}
