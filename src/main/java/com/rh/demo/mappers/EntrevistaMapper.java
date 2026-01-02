package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.EntrevistaDTO;
import com.rh.demo.model.entites.CandidatoEntity;
import com.rh.demo.model.entites.EntrevistaEntity;
import org.flywaydb.core.internal.proprietaryStubs.LicensingConfigurationExtensionStub;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EntrevistaMapper {

    public EntrevistaDTO toDTO(EntrevistaEntity entity){
        List<Long> candidatosIds = entity.getCandidatos()
                .stream()
                .map(CandidatoEntity::getId)
                .toList();

        return new EntrevistaDTO(
                entity.getId(),
                entity.getDataEntrevista(),
                entity.getTipoEntrevista(),
                entity.getResultadoEntrevista(),
                entity.getObservacoesEntrevista(),
                entity.getRecrutamento().getId(),
                candidatosIds
        );
    }
}
