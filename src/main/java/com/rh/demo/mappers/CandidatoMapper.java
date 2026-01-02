package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.CandidatoDTO;
import com.rh.demo.model.entites.CandidatoEntity;
import com.rh.demo.model.entites.EntrevistaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidatoMapper {

    public CandidatoDTO toDTO(CandidatoEntity entity){
        List<Long> entrevistaIds = entity.getEntrevista()
                .stream()
                .map(EntrevistaEntity::getId)
                .toList();
        return new CandidatoDTO(
                entity.getId(),
                entity.getNomeCandidato(),
                entity.getEmailCandidato(),
                entity.getTelefoneCandidato(),
                entity.getCurriculoUrl(),
                entity.getStatusCandidato(),
                entity.getRecrutamento(),
                entrevistaIds
        );
    }

    public CandidatoEntity toEntity(CandidatoDTO dto){
        CandidatoEntity entity = new CandidatoEntity();
        entity.setId(dto.id());
        entity.setNomeCandidato(dto.nomeCandidato());
        entity.setEmailCandidato(dto.emailCandidato());
        entity.setTelefoneCandidato(dto.telefoneCandidato());
        entity.setCurriculoUrl(dto.curriculoUrl());
        entity.setStatusCandidato(dto.statusCandidato());
        entity.setRecrutamento(dto.recrutamento());
        // Note: Mapping entrevistaIds to EntrevistaEntity list should be handled elsewhere
        return entity;
    }

}
