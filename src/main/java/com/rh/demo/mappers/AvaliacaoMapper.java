package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.AvaliacaoDTO;
import com.rh.demo.model.entites.AvaliacaoEntity;
import org.springframework.stereotype.Component;

@Component // Indica que esta classe é um componente gerenciado pelo Spring
public class AvaliacaoMapper {

    //caminho: entity para dto
    public AvaliacaoEntity toEntity(AvaliacaoDTO dto) {
        AvaliacaoEntity entity = new AvaliacaoEntity();
        entity.setId(dto.id());
        entity.setDataAvaliacao(dto.dataAvaliacao());
        entity.setNotaAvaliacao(dto.notaAvaliacao());
        entity.setFeedback(dto.feedback());
        return entity;
    }

    //caminho inverso: dto para entity
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
