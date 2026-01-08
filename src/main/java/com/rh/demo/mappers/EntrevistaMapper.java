package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.EntrevistaDTO;
import com.rh.demo.model.entites.CandidatoEntity;
import com.rh.demo.model.entites.EntrevistaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntrevistaMapper {

    public EntrevistaDTO toDTO(EntrevistaEntity entity){
        List<Long> candidatosIds = entity.getCandidatos() == null ? List.of()
                : entity.getCandidatos()
                .stream()
                .map(CandidatoEntity::getId)
                .toList();

        //se o recrutamento for nulo, atribui null ao recrutamentoId
        Long recrutamentoId = entity.getRecrutamento() != null
                ? entity.getRecrutamento().getId() : null;

        return new EntrevistaDTO(
                entity.getId(),
                entity.getDataEntrevista(),
                entity.getTipoEntrevista(),
                entity.getResultadoEntrevista(),
                entity.getObservacoesEntrevista(),
                recrutamentoId, //pega o id do recrutamento
                candidatosIds //pega a lista de ids dos candidatos
        );
    }
}
