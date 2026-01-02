package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.DepartamentoDTO;
import com.rh.demo.model.entites.DepartamentoEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartamentoMapper {

    // Conversão de Entity para DTO
    public DepartamentoDTO toDTO(DepartamentoEntity entity){
        List<Long> funcionariosIds = entity.getFuncionarios()
                .stream()
                .map(FuncionarioEntity::getId)
                .toList();

        return new DepartamentoDTO(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                funcionariosIds
        );
    }

    // Conversão de DTO para Entity
    public DepartamentoEntity toEntity(DepartamentoDTO dto){
        DepartamentoEntity entity = new DepartamentoEntity();
        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity.setDescricao(dto.descricao());
        // Note: Mapping funcionariosIds to their respective entity list should be handled elsewhere
        return entity;
    }
}
