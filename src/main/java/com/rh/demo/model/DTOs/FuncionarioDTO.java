package com.rh.demo.model.DTOs;

import com.rh.demo.enums.StatusFuncionario;
import com.rh.demo.model.entites.CargoEntity;
import com.rh.demo.model.entites.DepartamentoEntity;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

public record FuncionarioDTO(
        Long id,
        @NonNull
        String nome,
        @NonNull @Size(min = 1, max = 13)
        Long cpf,
        @NonNull @Size(min = 1, max = 13)
        Long telefone,
        @NonNull
        String email,
        @NonNull
        LocalDate dataNascimento,
        @NonNull
        LocalDate dataAdmissao,
        @NonNull @Size(min = 1, max = 13)
        Double salarioBase,
        @NonNull
        StatusFuncionario status,
        @NonNull
        Long departamentoId,
        @NonNull
        CargoEntity cargo,
        List<Long> pontoIds,
        List<Long> feriasIds,
        List<Long> avaliacaoIds,
        List<Long> treinamentoIds,
        List<Long> beneficioIds,
        List<Long> folhaPagamentoIds
) {
}
