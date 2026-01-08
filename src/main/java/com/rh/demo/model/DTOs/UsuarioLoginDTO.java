package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoUsuario;
import jakarta.validation.constraints.NotNull;

public record UsuarioLoginDTO(
        Long id,
        @NotNull //
        String username,
        @NotNull
        TipoUsuario tipoUsuario
) {
}
