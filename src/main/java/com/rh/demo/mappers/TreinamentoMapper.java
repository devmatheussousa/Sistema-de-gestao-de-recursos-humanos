package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.TreinamentoDTO;
import com.rh.demo.model.entites.CargoEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import com.rh.demo.model.entites.TreinamentoEntity;
import org.springframework.stereotype.Component;

@Component
public class TreinamentoMapper {

    public TreinamentoDTO toDTO(TreinamentoEntity entity){
        return new TreinamentoDTO(
        entity.getId(),
        entity.getNomeTreinamento(),
        entity.getDescricaoTreinamento(),
        entity.getCargaHoraria(),
        entity.getDataInicio(),
        entity.getDataFimTreinamento(),
        entity.getFuncionarios()
                .stream()
                .map(FuncionarioEntity::getId)
                .toList(),
        entity.getCargos()
                .stream()
                .map(CargoEntity::getId)
                .toList()
        );
    }

    public TreinamentoEntity toEntity(TreinamentoDTO dto){
        TreinamentoEntity entity = new TreinamentoEntity();

        entity.setId(dto.id());
        entity.setNomeTreinamento(dto.nomeTreinamento());
        entity.setDescricaoTreinamento(dto.descricaoTreinamento());
        entity.setCargaHoraria(dto.cargaHoraria());
        entity.setDataInicio(dto.dataInicio());
        entity.setDataFimTreinamento(dto.dataFimTreinamento());
        return entity;
    }
}
