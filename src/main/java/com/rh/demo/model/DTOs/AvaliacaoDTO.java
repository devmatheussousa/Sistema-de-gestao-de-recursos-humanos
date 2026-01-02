package com.rh.demo.model.DTOs;

public record AvaliacaoDTO(
        Long id,
        String dataAvaliacao,
        Integer notaAvaliacao,
        String feedback,
        Long funcionarioId
) {
}
