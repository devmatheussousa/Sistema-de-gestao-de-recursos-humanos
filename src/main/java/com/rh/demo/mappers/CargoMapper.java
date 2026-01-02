package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.CandidatoDTO;
import com.rh.demo.model.DTOs.CargoDTO;
import com.rh.demo.model.entites.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargoMapper {

    public CargoDTO toDTO(CargoEntity entity) {
        List<Long> treinamentosIds = entity.getTreinamentos()
                .stream()
                .map(TreinamentoEntity::getId)
                .toList();
        List<Long> recrutamentoIds = entity.getRecrutamentos()
                .stream()
                .map(RecrutamentoEntity::getId)
                .toList();
        return new CargoDTO(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getNivel(),
                entity.getSalario(),
                entity.getFuncionario(),
                treinamentosIds,
                recrutamentoIds
        );
    }

    public CargoEntity toEntity(CargoDTO dto) {
        CargoEntity entity = new CargoEntity();
        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity.setDescricao(dto.descricao());
        entity.setNivel(dto.nivel());
        entity.setSalario(dto.salario());
        entity.setFuncionario(dto.funcionario());
        // Note: Mapping treinamentosIds and recrutamentoIds to their respective entity lists should be handled elsewhere
        return entity;
    }
}
