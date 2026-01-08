package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoPonto;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PontoDTO(
        Long id,
        @NotNull
        LocalDate data,
        @NotNull
        LocalDateTime horaEntrada,
        @NotNull
        LocalDateTime horaSaida,
        @NotNull
        LocalTime horasTrabalhadas,
        @NotNull
        TipoPonto tipo,
        Long funcionarioId
) {
}
