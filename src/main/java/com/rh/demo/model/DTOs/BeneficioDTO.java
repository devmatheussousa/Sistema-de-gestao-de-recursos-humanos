package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoBeneficio;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

import java.util.List;

public record BeneficioDTO(
Long id,
@NonNull
String nome,
@NonNull @Size(max = 255)
String descricao,
@NonNull @DecimalMin( value = "0.0", inclusive = true)
Double valor,
@NonNull
TipoBeneficio tipoBeneficio,
@NonNull
@Size(min = 1)
List<Long> funcionariosIds
) {
}
