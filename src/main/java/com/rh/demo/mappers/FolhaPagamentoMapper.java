package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.FolhaPagamentoDTO;
import com.rh.demo.model.entites.FolhaPagamentoEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import org.springframework.stereotype.Component;

@Component
public class FolhaPagamentoMapper {

    public FolhaPagamentoDTO toDTO(FolhaPagamentoEntity folhaPagamento) {

        Long funcionarioId = folhaPagamento.getFuncionario() != null
                ? folhaPagamento.getFuncionario().getId()
                : null;

        return new FolhaPagamentoDTO(
                folhaPagamento.getId(),
                folhaPagamento.getMesAno(),
                folhaPagamento.getSalarioBruto(),
                folhaPagamento.getDescontos(),
                folhaPagamento.getBeneficios(),
                folhaPagamento.getSalarioLiquido(),
                folhaPagamento.getDataPagamento(),
                funcionarioId
        );
    }

    public FolhaPagamentoEntity toEntity(FolhaPagamentoDTO folhaPagamentoDTO) {

        FolhaPagamentoEntity folhaPagamento = new FolhaPagamentoEntity();

        folhaPagamento.setId(folhaPagamentoDTO.id());
        folhaPagamento.setMesAno(folhaPagamentoDTO.mesAno());
        folhaPagamento.setSalarioBruto(folhaPagamentoDTO.salarioBruto());
        folhaPagamento.setDescontos(folhaPagamentoDTO.descontos());
        folhaPagamento.setBeneficios(folhaPagamentoDTO.beneficios());
        folhaPagamento.setSalarioLiquido(folhaPagamentoDTO.salarioLiquido());
        folhaPagamento.setDataPagamento(folhaPagamentoDTO.dataPagamento());

        FuncionarioEntity funcionario = new FuncionarioEntity();
        funcionario.setId(folhaPagamentoDTO.funcionarioId());

        folhaPagamento.setFuncionario(funcionario);
        return folhaPagamento;
    }
}
