package com.rh.demo.services;

import com.rh.demo.mappers.AvaliacaoMapper;
import com.rh.demo.model.DTOs.AvaliacaoDTOs.AvaliacaoDTO;
import com.rh.demo.model.DTOs.AvaliacaoDTOs.PageResponse;
import com.rh.demo.model.entites.AvaliacaoEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import com.rh.demo.repositories.AvaliacaoRepository;
import com.rh.demo.repositories.FuncionarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service // Indica que esta classe é um serviço do Spring
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoMapper avaliacaoMapper;
    private final FuncionarioRepository funcionarioRepository;


    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, AvaliacaoMapper avaliacaoMapper, FuncionarioRepository funcionarioRepository){
        this.avaliacaoRepository = avaliacaoRepository;
        this.avaliacaoMapper = avaliacaoMapper;
        this.funcionarioRepository = funcionarioRepository;
    }

    //listar todas as avaliações com paginação
    public PageResponse<AvaliacaoDTO> listarAvaliacoes(int page, int size){
        Pageable pageable = PageRequest.of(page, size);

        Page<AvaliacaoEntity> pageResult = avaliacaoRepository.findAll(pageable);

        List<AvaliacaoDTO> content = pageResult
                .map(avaliacaoMapper::toDTO) // Mapeia cada entidade AvaliacaoEntity para um DTO AvaliacaoDTO
                .getContent(); // Obtém o conteúdo da página (lista de avaliações)

        return new PageResponse<>(
                content, // Lista de avaliações DTO na página atual
                pageResult.getNumber(), // Número da página atual (começando de 0)
                pageResult.getSize(), // Tamanho da página (quantidade de itens por página)
                pageResult.getTotalPages(), // Total de páginas disponíveis
                pageResult.getTotalElements(), // Total de elementos (avaliações) no conjunto de dados
                pageResult.isFirst(), // Indica se esta é a primeira página
                pageResult.isLast() // Indica se esta é a última página
        );
    }

    //listar todas as avaliações sem paginação
    @Transactional
    public List<AvaliacaoDTO> listarAvaliacoesSemPaginacao(){
        return avaliacaoRepository.findAll() // Busca todas as avaliações no repositório
                .stream() // Cria um fluxo (stream) para processar as avaliações individualmente
                .map(avaliacaoMapper::toDTO) // Mapeia cada entidade AvaliacaoEntity para um DTO AvaliacaoDTO
                .toList(); // Coleta os resultados em uma lista
    }


    // Buscar avaliação por ID
    public AvaliacaoDTO buscarAvaliacaoPorId(Long id){
        return avaliacaoRepository.findById(id) // Busca a avaliação pelo ID no repositório
                .map(avaliacaoMapper::toDTO) // Mapeia a entidade AvaliacaoEntity para AvaliacaoDTO, se encontrada
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não encontrada com o ID: " + id)); // Lança exceção se não encontrada
    }

    //criar uma avaliação
    public AvaliacaoDTO criarAvaliacao(AvaliacaoDTO avaliacaoDTO){

        // Busca o funcionário associado à avaliação pelo ID fornecido no DTO
        FuncionarioEntity funcionario = funcionarioRepository
                .findById(avaliacaoDTO.funcionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID: " + avaliacaoDTO.funcionarioId()));

        // Converte o DTO para a entidade AvaliacaoEntity
        AvaliacaoEntity avaliacaoEntity = avaliacaoMapper.toEntity(avaliacaoDTO);
        avaliacaoEntity.setFuncionario(funcionario); // Define o funcionário associado à avaliação

        // Salva a nova avaliação no repositório
        AvaliacaoEntity novaAvaliacao = avaliacaoRepository.save(avaliacaoEntity);
        return avaliacaoMapper.toDTO(novaAvaliacao);
    }

    //deletar uma avaliação
    @Transactional //garante que a operação de exclusão seja realizada dentro de uma transação
    public void deletarAvaliacao(Long id) {
        if(!avaliacaoRepository.existsById(id)){
            throw new RuntimeException("Avaliação não encontrada com o ID: " + id);
        }
        avaliacaoRepository.deleteById(id);
    }

    //atualizar uma avaliação
    @Transactional //garante que a operação de atualização seja realizada dentro de uma transação
    public AvaliacaoDTO atualizarAvaliacao(Long id, AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoEntity avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com o ID: " + id));

        avaliacao.setDataAvaliacao(avaliacaoDTO.dataAvaliacao());
        avaliacao.setNotaAvaliacao(avaliacaoDTO.notaAvaliacao());
        avaliacao.setFeedback(avaliacaoDTO.feedback());
        return avaliacaoMapper.toDTO(avaliacaoRepository.save(avaliacao));
    }
}
