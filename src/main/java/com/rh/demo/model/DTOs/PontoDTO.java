package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoPonto;
import com.rh.demo.model.entites.FuncionarioEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record PontoDTO(
        Long id,
        LocalDate data,
        LocalDateTime horaEntrada,
        LocalDateTime horaSaida,
        LocalTime horasTrabalhadas,
        TipoPonto tipo,
        FuncionarioEntity funcionario
) {
}
