package com.rh.demo.services;

import com.rh.demo.mappers.BeneficioMapper;
import com.rh.demo.model.DTOs.BeneficioDTO;
import com.rh.demo.repositories.BeneficioRepository;
import com.rh.demo.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BeneficioService {

    private final BeneficioRepository beneficioRepository;
    private final BeneficioMapper beneficioMapper;
    private final FuncionarioRepository funcionarioRepository;


    public BeneficioService(BeneficioRepository beneficioRepository, BeneficioMapper beneficioMapper, FuncionarioRepository funcionarioRepository) {
        this.beneficioRepository = beneficioRepository;
        this.beneficioMapper = beneficioMapper;
        this.funcionarioRepository = funcionarioRepository;
    }


    //Listar todos os benefícios
    public List<BeneficioDTO> listarBeneficios(){
        return beneficioRepository.findAll()
                .stream()
                .map(beneficioMapper::toDTO)
                .toList();
    }

    // Buscar benefício por ID
    public BeneficioDTO buscarBeneficioPorId(Long id){
        return beneficioRepository.findById(id)
                .map(beneficioMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Benefício não encontrado com o ID: " + id
                ));
    }

    //Criar benefício
    public BeneficioDTO criarBeneficio(BeneficioDTO beneficioDTO){
        //Cria o benefício
        var beneficioEntity = beneficioMapper.toEntity(beneficioDTO);
        beneficioEntity.setId(null); // Garante que o ID seja nulo para criação
        if(beneficioRepository.existsById(beneficioEntity.getId())){
                throw new RuntimeException("Benefício com ID " + beneficioEntity.getId() + " já existe.");
        }
        var beneficioSalvo = beneficioRepository.save(beneficioEntity);
        return beneficioMapper.toDTO(beneficioSalvo);
    }

    //Deletar benefício
    @Transactional
    public void deletarBeneficio(Long id){
        if(!beneficioRepository.existsById(id)){
            throw new RuntimeException("Benefício não encontrado com o ID: " + id);
        }
        beneficioRepository.deleteById(id);
    }

    // Atualizar benefício
    @Transactional
    public BeneficioDTO beneficioDTO(Long id, BeneficioDTO dto){
        var beneficio = beneficioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Benefício não encontrado com o ID: " + id));
        beneficio.setNome(dto.nome());
        beneficio.setValor(dto.valor());
        beneficio.setDescricao(dto.descricao());
        return beneficioMapper.toDTO(beneficio);
    }


}
