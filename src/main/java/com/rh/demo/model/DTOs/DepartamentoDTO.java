package com.rh.demo.model.DTOs;

import java.util.List;

public record DepartamentoDTO(
        Long id,
        String nome,
        String descricao,
        List<Long> funcionariosIds
) {
}
