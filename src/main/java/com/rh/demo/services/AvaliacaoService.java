package com.rh.demo.services;

import com.rh.demo.mappers.AvaliacaoMapper;
import com.rh.demo.model.DTOs.AvaliacaoDTO;
import com.rh.demo.model.entites.AvaliacaoEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import com.rh.demo.repositories.AvaliacaoRepository;
import com.rh.demo.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

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

    //listar todas as avaliações

    /**
     * Explicação detalhadado listarAvaliacoes:
     * Este méto-do é responsável por listar todas as avaliações paginadas.
     * Ele recebe um objeto Pageable como parâmetro, que contém informações sobre a página atual,
     * o tamanho da página e a ordenação dos resultados.
     * O méto-do utiliza o repositório de avaliações (avaliacaoRepository) para buscar todas as avaliações
     * do banco de dados, aplicando a paginação conforme especificado pelo objeto Pageable.
     * Em seguida, ele mapeia cada entidade AvaliacaoEntity para um DTO AvaliacaoDTO usando o avaliacaoMapper.
     * O resultado é retornado como um objeto Page<AvaliacaoDTO>, que contém a lista paginada de avaliações no formato DTO.
     * @param pageable Objeto Pageable que define a paginação e ordenação dos resultados.
     * @return Página de AvaliacaoDTO contendo as avaliações paginadas.
     *
     * O que é a ‘interface’ Pageable e Paginacão?:
     * A ‘interface’ Pageable é uma abstração fornecida pelo Spring Data que representa informações de paginação
     * e ordenação para consultas de banco de dados. Ela permite que você especifique qual página de resultados
     * deseja recuperar, quantos itens devem ser exibidos por página e como os resultados devem ser ordenados.
     * A paginação é uma técnica usada para dividir grandes conjuntos de dados em partes menores e mais gerenciáveis,
     * chamadas páginas. Isso é especialmente útil em aplicações ‘web’, onde exibir todos os resultados de uma vez pode ser ineficiente
     * e sobrecarregar o utilizador com muita informação. Com a paginação, você pode carregar e exibir apenas um subconjunto dos dados
     * por vez, melhorando a desempenho e a experiência do usuário.
     */
    public Page<AvaliacaoDTO> listarAvaliacoes(Pageable pageable){
        return avaliacaoRepository
                .findAll(pageable)
                .map(avaliacaoMapper::toDTO);
    }


    // Buscar avaliação por ID
    public AvaliacaoDTO buscarAvaliacaoPorId(Long id){
        return avaliacaoRepository.findById(id) // Busca a avaliação pelo ID no repositório
                .map(avaliacaoMapper::toDTO) // Mapeia a entidade AvaliacaoEntity para AvaliacaoDTO, se encontrada
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada com o ID: " + id)); // Lança exceção se não encontrada
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
