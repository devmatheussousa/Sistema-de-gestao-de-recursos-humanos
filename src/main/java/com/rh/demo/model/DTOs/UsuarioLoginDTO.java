package com.rh.demo.model.DTOs;

import com.rh.demo.enums.TipoUsuario;

public record UsuarioLoginDTO(
        Long id,
        String username,
        String password,
        TipoUsuario tipoUsuario
) {
}
