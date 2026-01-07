package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusRecrutamento;
import com.rh.demo.model.entites.CargoEntity;
import jakarta.validation.constraints.Min;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record RecrutamentoDTO(
        Long id,
        @NonNull
        String tituloVaga,
        @NonNull
        String descricaoVaga,
        @NonNull
        LocalDate dataAbertura,
        @NonNull
        LocalDateTime dataEncerramento,
        @NonNull
        StatusRecrutamento statusRecrutamento,
        @NonNull @Min(1)
        Long cargoId,
        List<Long> candidatosIds,
        List<Long> entrevistasIds
) {
}
