package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.FuncionarioDTO;
import com.rh.demo.model.entites.*;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioDTO toDTO(FuncionarioEntity entity){
        return new FuncionarioDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getTelefone(),
                entity.getEmail(),
                entity.getDataNascimento(),
                entity.getDataAdmissao(),
                entity.getSalarioBase(),
                entity.getStatus(),
                entity.getDepartamento(),
                entity.getCargo(),
                entity.getPonto().stream().map(PontoEntity::getId).toList(),
                entity.getFerias().stream().map(FeriasEntity::getId).toList(),
                entity.getAvaliacao().stream().map(AvaliacaoEntity::getId).toList(),
                entity.getTreinamentos().stream().map(TreinamentoEntity::getId).toList(),
                entity.getBeneficios().stream().map(BeneficioEntity::getId).toList(),
                entity.getFolhaPagamento().stream().map(FolhaPagamentoEntity::getId).toList()
        );
    }

    public FuncionarioEntity toEntity(FuncionarioDTO dto){
        FuncionarioEntity entity = new FuncionarioEntity();
        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity.setCpf(dto.cpf());
        entity.setTelefone(dto.telefone());
        entity.setEmail(dto.email());
        entity.setDataNascimento(dto.dataNascimento());
        entity.setDataAdmissao(dto.dataAdmissao());
        entity.setSalarioBase(dto.salarioBase());
        entity.setStatus(dto.status());
        entity.setDepartamento(dto.departamentoId());
        entity.setCargo(dto.cargo());
        // Note: Relationships like ponto, ferias, etc. should be handled separately
        return entity;
    }
}
