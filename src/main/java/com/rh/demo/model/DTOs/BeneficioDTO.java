package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoBeneficio;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record BeneficioDTO(
Long id,
@NotNull String nome,
@NotNull @Size(max = 255) String descricao,
@NotNull @DecimalMin( value = "0.0", inclusive = true)
Double valor,
@NotNull TipoBeneficio tipoBeneficio,
@NotNull List<@NotNull Long> funcionariosIds
) {
}
