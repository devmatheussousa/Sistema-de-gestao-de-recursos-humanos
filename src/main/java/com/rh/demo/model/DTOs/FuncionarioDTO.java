package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusFuncionario;
import com.rh.demo.model.entites.CargoEntity;
import com.rh.demo.model.entites.DepartamentoEntity;

import java.time.LocalDate;
import java.util.List;

public record FuncionarioDTO(
        Long id,
        String nome,
        Long cpf,
        Long telefone,
        String email,
        LocalDate dataNascimento,
        LocalDate dataAdmissao,
        Double salarioBase,
        StatusFuncionario status,
        DepartamentoEntity departamentoId,
        CargoEntity cargo,
        List<Long> pontoIds,
        List<Long> feriasIds,
        List<Long> avaliacaoIds,
        List<Long> treinamentoIds,
        List<Long> beneficioIds,
        List<Long> folhaPagamentoIds
) {
}
