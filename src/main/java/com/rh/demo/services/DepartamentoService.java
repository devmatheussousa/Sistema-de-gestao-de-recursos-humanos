package com.rh.demo.services;

import com.rh.demo.mappers.DepartamentoMapper;
import com.rh.demo.model.DTOs.CandidatoDTO;
import com.rh.demo.model.DTOs.DepartamentoDTO;
import com.rh.demo.repositories.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;

    //Listar todos os Departamento
    @Transactional
    public List<DepartamentoDTO> listarTodos(){
        return departamentoRepository.findAll()
                .stream()
                .map(departamentoMapper::toDTO)
                .toList();
    }

    //Buscar candidatos por ID
    @Transactional
    public DepartamentoDTO buscarCandidatoPorId(Long id){

        return departamentoRepository.findById(id)
                .map(departamentoMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Departamento não encontrado"));
    }


    //Criar departamento
    @Transactional
   public DepartamentoDTO criarDepartamento(DepartamentoDTO departamentoDTO){
        var departamentoSalvo = departamentoMapper.toEntity(departamentoDTO);//Convertendo DTO para entidade
        departamentoRepository.save(departamentoSalvo); //Salvando entidade no banco de dados
        return departamentoMapper.toDTO(departamentoSalvo); //Convertendo entidade para DTO
    }

    //Deletar departamento por ID
    @Transactional
    public void deletarDepartamento(Long id){
        var departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Departamento não encontrado"));
        departamentoRepository.delete(departamento);
    }

    //Atualizar departamento por ID
    @Transactional
    public DepartamentoDTO atualizarDepartamento(long id, DepartamentoDTO departamentoDTO){
        //buscar candidato pelo ID
        var departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Departamento não encontrado"));
        //Atualizar campos do departamento com base nos dados do DTO
        departamento.setNome(departamentoDTO.nome());
        departamento.setDescricao(departamentoDTO.descricao());
        //Salvar departamento atualizado no banco de dados
        departamentoRepository.save(departamento);
        //Retornar DTO com os dados atualizados
        return departamentoMapper.toDTO(departamento);
    }
}
