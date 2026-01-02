package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoBeneficio;

import java.util.List;

public record BeneficioDTO(
Long id,
String nome,
String descricao,
Double valor,
TipoBeneficio tipoBeneficio,
List<Long> funcionariosIds
) {
}
