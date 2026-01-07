package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoUsuario;
import org.springframework.lang.NonNull;

public record UsuarioLoginDTO(
        Long id,
        @NonNull
        String username,
        @NonNull
        String password,
        @NonNull
        TipoUsuario tipoUsuario
) {
}
