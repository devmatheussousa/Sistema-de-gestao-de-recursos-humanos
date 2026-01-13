package com.rh.demo.services;

import com.rh.demo.mappers.EntrevistaMapper;
import com.rh.demo.model.DTOs.EntrevistaDTO;
import com.rh.demo.repositories.EntrevistaRepository;
import com.rh.demo.repositories.RecrutamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrevistaService {

    private final EntrevistaRepository entrevistaRepository;
    private final EntrevistaMapper entrevistaMapper;
    private final RecrutamentoRepository recrutamentoRepository; // para buscar o recrutamento pelo id


    //Criar entrevista
    public EntrevistaDTO criarEntrevista(EntrevistaDTO dto){
        var entrevista = entrevistaMapper.toEntity(dto);
        //buscar o recrutamento pelo id
        var recrutamento = recrutamentoRepository.findById(dto.recrutamentoId())
                .orElseThrow(() -> new IllegalArgumentException("Recrutamento não encontrado"));
        entrevista.setRecrutamento(recrutamento);
        //salvar a entrevista
        entrevistaRepository.save(entrevista);
        return entrevistaMapper.toDTO(entrevista);
    }

    //Buscar entrevista por id com candidatos associados
    public EntrevistaDTO buscarEntrevistaPorIdComCandidatos(Long id){
        var entrevista = entrevistaRepository.findById(id) //busca a entrevista pelo id
                .orElseThrow(() -> new IllegalArgumentException("Entrevista não encontrada"));
        return entrevistaMapper.toDTO(entrevista); //retorna a entrevista como DTO
    }


}
