package com.rh.demo.model.DTOs;

import com.rh.demo.model.entites.FuncionarioEntity;
import java.time.LocalDate;

public record AvaliacaoDTO(
        Long id,
        LocalDate dataAvaliacao,
        Integer notaAvaliacao,
        String feedback,
        Long funcionarioId
) {
}
