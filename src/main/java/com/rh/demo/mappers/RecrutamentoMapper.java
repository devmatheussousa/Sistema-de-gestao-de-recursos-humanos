package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.RecrutamentoDTO;
import com.rh.demo.model.entites.CandidatoEntity;
import com.rh.demo.model.entites.EntrevistaEntity;
import com.rh.demo.model.entites.RecrutamentoEntity;
import org.springframework.stereotype.Component;

@Component
public class RecrutamentoMapper {

    RecrutamentoDTO toDTO(RecrutamentoEntity entity) {
        return new RecrutamentoDTO(
                entity.getId(),
                entity.getTituloVaga(),
                entity.getDescricaoVaga(),
                entity.getDataAbertura(),
                entity.getDataEncerramento(),
                entity.getStatusRecrutamento(),
                entity.getCargo(),
                entity.getCandidatos().stream().map(CandidatoEntity::getId).toList(),
                entity.getEntrevistas().stream().map(EntrevistaEntity::getId).toList()
        );
    }

    RecrutamentoEntity toEntity(RecrutamentoDTO dto) {
        RecrutamentoEntity entity = new RecrutamentoEntity();
        entity.setId(dto.id());
        entity.setTituloVaga(dto.tituloVaga());
        entity.setDescricaoVaga(dto.descricaoVaga());
        entity.setDataAbertura(dto.dataAbertura());
        entity.setDataEncerramento(dto.dataEncerramento());
        entity.setStatusRecrutamento(dto.statusRecrutamento());
        entity.setCargo(dto.cargo());
        // Note: Candidatos and Entrevistas should be set separately, as we only have their IDs in the DTO
        return  entity;
    }
}
