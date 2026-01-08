package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.FuncionarioDTO;
import com.rh.demo.model.entites.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FuncionarioMapper {

    public FuncionarioDTO toDTO(FuncionarioEntity entity){

        return new FuncionarioDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getTelefone() != null
                        ? entity.getTelefone().toString()
                        : null,
                entity.getEmail(),
                entity.getDataNascimento(),
                entity.getDataAdmissao(),
                entity.getSalarioBase(),
                entity.getStatus(),
                entity.getDepartamento() != null
                        ? entity.getDepartamento().getId()
                        : null,
                entity.getCargo() != null
                        ? entity.getCargo().getId()
                        : null,
                entity.getPonto() == null ? List.of()
                        : entity.getPonto().stream()
                        .map(PontoEntity::getId)
                        .toList(),
                entity.getFerias() == null ? List.of()
                        : entity.getFerias().stream()
                        .map(FeriasEntity::getId)
                        .toList(),
                entity.getAvaliacao() == null ? List.of()
                        : entity.getAvaliacao().stream()
                        .map(AvaliacaoEntity::getId)
                        .toList(),
                entity.getTreinamentos() == null ? List.of()
                        : entity.getTreinamentos().stream()
                        .map(TreinamentoEntity::getId)
                        .toList(),
                entity.getBeneficios() == null ? List.of()
                        : entity.getBeneficios().stream()
                        .map(BeneficioEntity::getId)
                        .toList(),
                entity.getFolhaPagamento() == null ? List.of()
                        : entity.getFolhaPagamento().stream()
                        .map(FolhaPagamentoEntity::getId)
                        .toList()
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

        if(dto.departamentoId() != null){
            DepartamentoEntity departamento = new DepartamentoEntity();
            departamento.setId(dto.departamentoId());
            entity.setDepartamento(departamento);
        }

        if(dto.cargoId() != null){
            CargoEntity cargo = new CargoEntity();
            cargo.setId(dto.cargoId());
            entity.setCargo(cargo);
        }
        return entity;
    }
}
