package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.UsuarioLoginDTO;
import com.rh.demo.model.entites.UsuarioLoginEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLoginMapper {

    public UsuarioLoginDTO toDTO(UsuarioLoginEntity entity){
        return new UsuarioLoginDTO(
                entity.getId(),
                entity.getUsername(),
                entity.getTipoUsuario()
        );
    }

    public UsuarioLoginEntity toEntity(UsuarioLoginDTO dto){
        UsuarioLoginEntity entity = new UsuarioLoginEntity();
        entity.setId(dto.id());
        entity.setUsername(dto.username());
        entity.setTipoUsuario(dto.tipoUsuario());

        return entity;
    }
}
