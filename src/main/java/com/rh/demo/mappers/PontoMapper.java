package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.PontoDTO;
import com.rh.demo.model.entites.FuncionarioEntity;
import com.rh.demo.model.entites.PontoEntity;
import org.springframework.stereotype.Component;

@Component
public class PontoMapper {
    public PontoDTO toDTO(PontoEntity entity){
        return new PontoDTO(
                entity.getId(),
                entity.getData(),
                entity.getHoraEntrada(),
                entity.getHoraSaida(),
                entity.getHorasTrabalhadas(),
                entity.getTipo(),
                entity.getFuncionario() != null
                ? entity.getFuncionario().getId()
                        :null
        );
    }

    public PontoEntity toEntity(PontoDTO dto){
        PontoEntity entity = new PontoEntity();
        entity.setId(dto.id());
        entity.setData(dto.data());
        entity.setHoraEntrada(dto.horaEntrada());
        entity.setHoraSaida(dto.horaSaida());
        entity.setHorasTrabalhadas(dto.horasTrabalhadas());
        entity.setTipo(dto.tipo());

        if(dto.funcionarioId() != null){
            FuncionarioEntity funcionario = new FuncionarioEntity();
            funcionario.setId(dto.funcionarioId());
            entity.setFuncionario(funcionario);
        }

        return entity;
    }
}
