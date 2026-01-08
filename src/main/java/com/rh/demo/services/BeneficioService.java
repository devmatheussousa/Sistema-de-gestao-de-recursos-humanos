package com.rh.demo.services;

import com.rh.demo.mappers.BeneficioMapper;
import com.rh.demo.model.DTOs.AvaliacaoDTO;
import com.rh.demo.model.DTOs.BeneficioDTO;
import com.rh.demo.model.entites.FuncionarioEntity;
import com.rh.demo.repositories.BeneficioRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeneficioService {

    private final BeneficioRepository beneficioRepository;
    private final BeneficioMapper beneficioMapper;


    public BeneficioService(BeneficioRepository beneficioRepository, BeneficioMapper beneficioMapper) {
        this.beneficioRepository = beneficioRepository;
        this.beneficioMapper = beneficioMapper;
    }


    //Listar todos os benefícios
    public Page<BeneficioDTO> listarBeneficios(Pageable pageable){
        return beneficioRepository
                .findAll(pageable) // Busca todos os benefícios com paginação
                .map(beneficioMapper::toDTO); // Mapeia cada entidade Beneficio
    }

    // Buscar benefício por ID
    public Optional<BeneficioDTO> buscarBeneficioPorId(Long id){
        return Optional.ofNullable(beneficioRepository.findById(id)
                .map(beneficioMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Benefício não encontrado com o ID: " + id)));
    }

    //Criar benefício
    public BeneficioDTO criarBeneficio(BeneficioDTO beneficioDTO, Long id){
        var beneficioEntity = beneficioMapper.toEntity(beneficioDTO);
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
    public AvaliacaoDTO avaliacaoDTO(Long id, BeneficioDTO beneficioDTO){
        var beneficio = beneficioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Benefício não encontrado com o ID: " + id));
        beneficio.setNome(beneficioDTO.nome());
        beneficio.setDescricao(beneficioDTO.descricao());
        beneficio.setValor(beneficioDTO.valor());
        beneficio.setTipoBeneficio(beneficioDTO.tipoBeneficio());
        var beneficioAtualizado = beneficioRepository.save(beneficio);
        return beneficioMapper.toDTO(beneficioAtualizado);
    }


}
