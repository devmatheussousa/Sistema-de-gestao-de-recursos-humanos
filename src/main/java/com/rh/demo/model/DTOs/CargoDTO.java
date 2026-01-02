package com.rh.demo.model.DTOs;

import com.rh.demo.model.entites.FuncionarioEntity;

import java.util.List;

public record CargoDTO(
        Long id,
        String nome,
        String descricao,
        String nivel,
        Double salario,
        FuncionarioEntity funcionario,
        List<Long> treinamentosIds,
        List<Long> recrutamentosIds
) {
}
