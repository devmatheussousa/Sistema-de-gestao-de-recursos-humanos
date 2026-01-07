package com.rh.demo.model.DTOs;

import com.rh.demo.model.entites.FuncionarioEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

public record AvaliacaoDTO(
        Long id,

        @NonNull
        LocalDate dataAvaliacao,

        @NonNull
        @Min(0)
        @Max(10)
        Integer notaAvaliacao,
        @Size(max = 255)
        String feedback,
        @NotNull
        Long funcionarioId
) {
}
