package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.RecrutamentoDTO;
import com.rh.demo.model.entites.CandidatoEntity;
import com.rh.demo.model.entites.CargoEntity;
import com.rh.demo.model.entites.EntrevistaEntity;
import com.rh.demo.model.entites.RecrutamentoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

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
                entity.getCargo() != null
                        ? entity.getCargo().getId()
                        : null,
                entity.getCandidatos() == null
                ? List.of()
                : entity.getCandidatos().stream()
                        .map(CandidatoEntity::getId)
                        .toList(),
                entity.getEntrevistas() == null
                ? List.of()
                : entity.getEntrevistas().stream()
                        .map(EntrevistaEntity::getId)
                        .toList()

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
        entity.setStatusRecrutamento(dto.statusRecrutamento());

        if(dto.cargoId() != null) {
            CargoEntity cargo = new CargoEntity();
            cargo.setId(dto.cargoId());
            entity.setCargo(cargo);
        }
        return  entity;
    }
}
