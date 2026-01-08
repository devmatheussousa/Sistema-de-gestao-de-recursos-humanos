package com.rh.demo.model.DTOs;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FolhaPagamentoDTO(
        Long id,
        @NotNull
        LocalDate mesAno,
        @NotNull @DecimalMin(value = "0.0", inclusive = true)
        Double salarioBruto,
        @NotNull @DecimalMin(value = "0.0", inclusive = true)
        Double descontos,
        @NotNull
        String beneficios,
        @NotNull @DecimalMin(value = "0.0", inclusive = true)
        Double salarioLiquido,
        @NotNull
        LocalDate dataPagamento,
        @NotNull
        Long funcionarioId
) {
}
