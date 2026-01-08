package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusFerias;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FeriasDTO(
        Long id,
        @NotNull
        LocalDate dataInicio,
        @NotNull
        LocalDate dataFim,
        @NotNull @Min(1)
        Integer dias,
        @NotNull
        StatusFerias statusFerias,
        @NotNull
        Long funcionarioId
) {
}
