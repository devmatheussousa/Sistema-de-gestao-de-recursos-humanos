package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoPonto;
import com.rh.demo.model.entites.FuncionarioEntity;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PontoDTO(
        Long id,
        @NonNull
        LocalDate data,
        @NonNull
        LocalDateTime horaEntrada,
        @NonNull
        LocalDateTime horaSaida,
        @NonNull
        LocalTime horasTrabalhadas,
        @NonNull
        TipoPonto tipo,
        Long funcionarioId
) {
}
