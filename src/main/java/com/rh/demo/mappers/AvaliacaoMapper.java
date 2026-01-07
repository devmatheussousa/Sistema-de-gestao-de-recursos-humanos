package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.AvaliacaoDTO;
import com.rh.demo.model.entites.AvaliacaoEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapper {

    // DTO → Entity
    public AvaliacaoEntity toEntity(AvaliacaoDTO dto) {
        AvaliacaoEntity entity = new AvaliacaoEntity();
        entity.setId(dto.id());
        entity.setDataAvaliacao(dto.dataAvaliacao());
        entity.setNotaAvaliacao(dto.notaAvaliacao());
        entity.setFeedback(dto.feedback());

        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setId(dto.funcionarioId());
        entity.setFuncionario(funcionario);

        return entity;
    }

    // Entity → DTO
    public AvaliacaoDTO toDTO(AvaliacaoEntity entity) {
        return new AvaliacaoDTO(
                entity.getId(),
                entity.getDataAvaliacao(),
                entity.getNotaAvaliacao(),
                entity.getFeedback(),
                entity.getFuncionario().getId()
        );
    }
}
