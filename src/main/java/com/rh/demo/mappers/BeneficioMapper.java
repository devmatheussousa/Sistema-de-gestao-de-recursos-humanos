package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.BeneficioDTO;
import com.rh.demo.model.entites.BeneficioEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeneficioMapper {

    //caminho de DTO a Entity
    public BeneficioDTO toDTO(BeneficioEntity entity){
        List<Long> funcionariosIds = entity.getFuncionarios()
                .stream()
                .map(FuncionarioEntity::getId)
                .toList();

        return new BeneficioDTO(
                entity.getNome(),
                entity.getDescricao(),
                entity.getValor(),
                entity.getTipoBeneficio(),
                funcionariosIds
        );
    }

    //caminho inverso Entity a DTO
    public BeneficioEntity toEntity(BeneficioDTO dto){
        BeneficioEntity entity = new BeneficioEntity();
        entity.setNome(dto.nome());
        entity.setDescricao(dto.descricao());
        entity.setValor(dto.valor());
        entity.setTipoBeneficio(dto.tipoBeneficio());
        // Note: Mapping funcionariosIds to FuncionarioEntity list should be handled elsewhere
        return entity;
    }
}
