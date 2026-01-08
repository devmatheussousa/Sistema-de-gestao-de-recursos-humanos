package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.CandidatoDTO;
import com.rh.demo.model.entites.CandidatoEntity;
import com.rh.demo.model.entites.EntrevistaEntity;
import com.rh.demo.model.entites.RecrutamentoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidatoMapper {

    public CandidatoDTO toDTO(CandidatoEntity entity){
        /**
         * ❌ Erro potencial:
         * - entity.getEntrevista() pode ser null → NullPointerException.
         *
         * ✅ Correção:
         * - Garantir lista vazia quando não houver entrevistas.
         */
        List<Long> entrevistaIds = entity.getEntrevistas() == null
                ? List.of()
                : entity.getEntrevistas()
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
                entity.getRecrutamento().getId(), // ❌ Antes:Retornava RecrutamentoEntity no DTO.
                entrevistaIds
        );
    }

    public CandidatoEntity toEntity(CandidatoDTO dto){
        CandidatoEntity entity = new CandidatoEntity();

        /*
          ❌ Erro conceitual:
          - Mapper NÃO deve montar relacionamento completo.
          - Mapper NÃO deve acessar repositório.
          <p>
          ✅ Correção:
          - Criar entidade com ID (referência).
          - Resolução completa fica no Service.
         */

        RecrutamentoEntity recrutamento = new RecrutamentoEntity();
        recrutamento.setId(dto.id());
        entity.setId(dto.id());
        entity.setNomeCandidato(dto.nomeCandidato());
        entity.setEmailCandidato(dto.emailCandidato());
        entity.setTelefoneCandidato(dto.telefoneCandidato());
        entity.setCurriculoUrl(dto.curriculoUrl());
        entity.setStatusCandidato(dto.statusCandidato());
        entity.setRecrutamento(recrutamento);
        // Note: Mapping entrevistaIds to EntrevistaEntity list should be handled elsewhere
        return entity;
    }

}
