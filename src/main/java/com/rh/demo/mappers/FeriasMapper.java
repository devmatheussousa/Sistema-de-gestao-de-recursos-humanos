package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.FeriasDTO;
import com.rh.demo.model.entites.FeriasEntity;
import org.springframework.stereotype.Component;

@Component
public class FeriasMapper {

    public FeriasDTO toDTO(FeriasEntity entity) {
        return new FeriasDTO(
                entity.getId(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getDias(),
                entity.getStatusFerias(),
                entity.getFuncionario()
        );
    }

    public FeriasEntity toEntity(FeriasDTO dto) {
        FeriasEntity entity = new FeriasEntity();
        entity.setId(dto.id());
        entity.setDataInicio(dto.dataInicio());
        entity.setDataFim(dto.dataFim());
        entity.setDias(dto.dias());
        entity.setStatusFerias(dto.statusFerias());
        entity.setFuncionario(dto.funcionario());
        return entity;
    }
}
