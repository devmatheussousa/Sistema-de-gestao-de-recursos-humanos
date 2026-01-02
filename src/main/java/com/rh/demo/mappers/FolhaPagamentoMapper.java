package com.rh.demo.mappers;

import com.rh.demo.model.DTOs.FolhaPagamentoDTO;
import com.rh.demo.model.entites.FolhaPagamentoEntity;
import org.springframework.stereotype.Component;

@Component
public class FolhaPagamentoMapper {

    public FolhaPagamentoDTO toDTO(FolhaPagamentoEntity folhaPagamento) {
        return new FolhaPagamentoDTO(
                folhaPagamento.getId(),
                folhaPagamento.getMesAno(),
                folhaPagamento.getSalarioBruto(),
                folhaPagamento.getDescontos(),
                folhaPagamento.getBeneficios(),
                folhaPagamento.getSalarioLiquido(),
                folhaPagamento.getDataPagamento(),
                folhaPagamento.getFuncionario()
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
        folhaPagamento.setFuncionario(folhaPagamentoDTO.funcionario());
        return folhaPagamento;
    }
}
