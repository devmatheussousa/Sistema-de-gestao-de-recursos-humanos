package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusFerias;
import com.rh.demo.model.entites.FuncionarioEntity;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.Date;

public record FeriasDTO(
        Long id,
        @Override
        LocalDate dataInicio,
        @Override
        LocalDate dataFim,
        @NonNull @Size(min = 1)
        Integer dias,
        @NonNull
        StatusFerias statusFerias,
        @NonNull
        FuncionarioEntity funcionario
) {
}
