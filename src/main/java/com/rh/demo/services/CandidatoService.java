package com.rh.demo.services;

import com.rh.demo.mappers.CandidatoMapper;
import com.rh.demo.model.DTOs.CandidatoDTO;
import com.rh.demo.model.entites.CandidatoEntity;
import com.rh.demo.model.entites.RecrutamentoEntity;
import com.rh.demo.repositories.CandidatoRepository;
import com.rh.demo.repositories.RecrutamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;
    private final CandidatoMapper candidatoMapper;
    private final RecrutamentoRepository recrutamentoRepository;

    //listar todos os candidatos
    @Transactional
    public List<CandidatoDTO> listarTodosOsCandidatos(){
        return candidatoRepository.findAll().stream()
                .map(candidatoMapper::toDTO)
                .toList();
    }

    //Buscar candidatos por ID
    public CandidatoDTO buscarCandidadtoPorId(Long id){
        return candidatoRepository.findById(id)
                .map(candidatoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
    }

    //criar candidato
    public CandidatoDTO criarCandidato(CandidatoDTO candidatoDTO){

        //Buscar recrutamento pelo ID
        RecrutamentoEntity recrutamentoEntity = recrutamentoRepository.findById(candidatoDTO.recrutamentoId())
                .orElseThrow(() -> new RuntimeException("Recrutamento não encontrado"));

        //Converter DTO para Entity
        CandidatoEntity candidatoEntity = candidatoMapper.toEntity(candidatoDTO);

        candidatoEntity.setId(null);

        //Associar recrutamento ao candidato
        candidatoEntity.setRecrutamento(recrutamentoEntity);

        //Salvar candidato no banco de dados
       CandidatoEntity candidatoSalvo = candidatoRepository.save(candidatoEntity);

        //Retornar DTO do candidato salvo
        return candidatoMapper.toDTO(candidatoSalvo);
    }

    //Deletar Candidato
    @Transactional
    public void deletarCandidato(Long id){
        CandidatoEntity candidato = candidatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
        candidatoRepository.delete(candidato);
    }

    @Transactional
    public CandidatoDTO atualizarCandidato(Long id, CandidatoDTO candidatoDTO){
        //Buscar candidato pelo ID
        CandidatoEntity candidatoEntity = candidatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));

        //Atualizar campos do candidato com os valores do DTO
        candidatoEntity.setNomeCandidato(candidatoDTO.nomeCandidato());
        candidatoEntity.setEmailCandidato(candidatoDTO.emailCandidato());
        candidatoEntity.setTelefoneCandidato(candidatoDTO.telefoneCandidato());
        candidatoEntity.setStatusCandidato(candidatoDTO.statusCandidato());

        //Salvar candidato atualizado no banco de dados
        CandidatoEntity candidatoAtualizado = candidatoRepository.save(candidatoEntity);

        //Retornar DTO do candidato atualizado
        return candidatoMapper.toDTO(candidatoAtualizado);
    }


}
