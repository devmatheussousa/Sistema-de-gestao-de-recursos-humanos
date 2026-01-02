package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusFerias;
import com.rh.demo.model.entites.FuncionarioEntity;

import java.time.LocalDate;

public record FeriasDTO(
        Long id,
        LocalDate dataInicio,
        Double dataFim,
        Integer dias,
        StatusFerias statusFerias,
        FuncionarioEntity funcionario
) {
}
