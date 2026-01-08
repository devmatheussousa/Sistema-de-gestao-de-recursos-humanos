package com.rh.demo.model.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record DepartamentoDTO(
        Long id,
        @NotNull
        String nome,
        @NotNull @Size(min = 1, max = 255)
        String descricao,
        List<Long> funcionariosIds
) {
}
