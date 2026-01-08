package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusRecrutamento;
import com.rh.demo.model.entites.CargoEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record RecrutamentoDTO(
        Long id,
        @NotNull
        String tituloVaga,
        @NotNull
        String descricaoVaga,
        @NotNull
        LocalDate dataAbertura,
        @NotNull
        LocalDateTime dataEncerramento,
        @NotNull
        StatusRecrutamento statusRecrutamento,
        @NotNull
        Long cargoId,
        List<@NotNull Long> candidatosIds,
        List<@NotNull Long> entrevistasIds
) {
}
