package com.rh.demo.model.DTOs;

import com.rh.demo.model.entites.FuncionarioEntity;

import java.time.LocalDate;

public record FolhaPagamentoDTO(
        Long id,
        LocalDate mesAno,
        Double salarioBruto,
        Double descontos,
        String beneficios,
        Double salarioLiquido,
        LocalDate dataPagamento,
        FuncionarioEntity funcionario
) {
}
