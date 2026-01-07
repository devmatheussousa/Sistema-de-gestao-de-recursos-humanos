package com.rh.demo.model.DTOs;

import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.List;

public record DepartamentoDTO(
        Long id,
        @NonNull
        String nome,
        @NonNull @Size(min = 1, max = 255)
        String descricao,
        List<Long> funcionariosIds
) {
}
