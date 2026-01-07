package com.rh.demo.model.DTOs;

import jakarta.validation.constraints.DecimalMin;
import org.springframework.lang.NonNull;

import java.lang.annotation.Native;
import java.time.LocalDate;

public record FolhaPagamentoDTO(
        Long id,
        @NonNull
        LocalDate mesAno,
        @NonNull @DecimalMin(value = "0.0", inclusive = true)
        Double salarioBruto,
        @NonNull @DecimalMin(value = "0.0", inclusive = true)
        Double descontos,
        @NonNull
        String beneficios,
        @NonNull @DecimalMin(value = "0.0", inclusive = true)
        Double salarioLiquido,
        @NonNull
        LocalDate dataPagamento,
        @NonNull
        Long funcionarioId
) {
}
