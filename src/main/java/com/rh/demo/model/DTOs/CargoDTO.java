package com.rh.demo.model.DTOs;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CargoDTO(
        Long id,

        @NotNull String nome,
        @Size(max = 255) String descricao,
        @NotNull String nivel,
        @NotNull @DecimalMin(value = "0.0", inclusive = true)
        Double salario,
        @NotNull Long funcionarioId,

        List<Long> treinamentosIds,
        List<Long> recrutamentoIds
) {
}
