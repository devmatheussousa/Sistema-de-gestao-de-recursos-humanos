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

                /*
                  ❌ ERRO ANTERIOR:
                  entity.getFuncionario()

                  DTO NÃO recebe Entity

                  ✅ CORRETO:
                  Extrair apenas o ID do relacionamento
                 */

                entity.getFuncionario() != null
                ? entity.getFuncionario().getId()
                        : null,
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

        /*
          ❌ ERRO CONCEITUAL COMUM:
          tentar fazer:
          entity.setFuncionario(dto.funcionario())

          DTO NÃO possui FuncionarioEntity

          ✅ CORRETO:
          O relacionamento deve ser resolvido no SERVICE,
          buscando o FuncionarioEntity pelo ID

          Exemplo no service:
          FuncionarioEntity f = funcionarioRepository.findById(dto.funcionarioId())
         */
        // entity.setFuncionario(...); // resolvido no service

        /*
          Mesma regra para:
          - treinamentosIds
          - recrutamentoIds

          Mapper NÃO acessa banco
         */

        // Note: Mapping treinamentosIds and recrutamentoIds to their respective entity lists should be handled elsewhere
        return entity;
    }
}
