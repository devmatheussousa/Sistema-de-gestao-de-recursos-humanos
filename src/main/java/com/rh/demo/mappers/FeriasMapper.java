package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.FeriasDTO;
import com.rh.demo.model.entites.FeriasEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import org.springframework.stereotype.Component;

@Component
public class FeriasMapper {

    public FeriasDTO toDTO(FeriasEntity entity) {
        Long funcionarioId = entity.getFuncionario() != null
                ? entity.getFuncionario().getId()
                : null;
        return new FeriasDTO(
                entity.getId(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getDias(),
                entity.getStatusFerias(),
                funcionarioId
        );
    }

    public FeriasEntity toEntity(FeriasDTO dto) {
        FeriasEntity entity = new FeriasEntity();
        entity.setId(dto.id());
        entity.setDataInicio(dto.dataInicio());
        entity.setDataFim(dto.dataFim());
        entity.setDias(dto.dias());
        entity.setStatusFerias(dto.statusFerias());

        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setId(dto.funcionarioId());
        entity.setFuncionario(funcionario);
        return entity;
    }
}
