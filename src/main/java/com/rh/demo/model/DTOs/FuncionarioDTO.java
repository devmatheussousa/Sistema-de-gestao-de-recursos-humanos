package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusFuncionario;
import com.rh.demo.model.entites.CargoEntity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record FuncionarioDTO(
        Long id,

        @NotNull
        String nome,

        @NotNull @Size(min = 1, max = 13)
        String cpf,

        @NotNull @Size(min = 1, max = 13)
        String telefone,

        @NotNull @Size(min = 1, max = 50)
        String email,

        @NotNull
        LocalDate dataNascimento,

        @NotNull
        LocalDate dataAdmissao,

        @NotNull @DecimalMin("0.0")
        Double salarioBase,

        @NotNull
        StatusFuncionario status,

        @NotNull
        Long departamentoId,

        @NotNull
        Long cargoId,

        List<Long> pontoIds,
        List<Long> feriasIds,
        List<Long> avaliacaoIds,
        List<Long> treinamentoIds,
        List<Long> beneficioIds,
        List<Long> folhaPagamentoIds
) {
}
