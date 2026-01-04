package com.rh.demo.controllers;

import com.rh.demo.model.DTOs.AvaliacaoDTO;
import com.rh.demo.services.AvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;


    //criar avaliação
    @PostMapping("/criar")
    public ResponseEntity<AvaliacaoDTO> criarAvaliacao(@RequestBody AvaliacaoDTO novaAvaliacaoDTO){
       AvaliacaoDTO avaliacaoDTO = avaliacaoService.criarAvaliacao(novaAvaliacaoDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoDTO);
    }

    //Listar avaliações com paginação
    @GetMapping("/listar")
    public ResponseEntity<Page<AvaliacaoDTO>> listarAvaliacoes(Pageable pageable){
        Page<AvaliacaoDTO> avaliacoesPage = avaliacaoService.listarAvaliacoes(pageable);
        return ResponseEntity.ok(avaliacoesPage);
    }

    //Buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoDTO> buscarAvaliacaoPorId(@PathVariable Long id) {
        return avaliacaoService.buscarAvaliacaoPorId(id) // Busca a avaliação pelo ID usando o serviço
                .map(ResponseEntity::ok) // Se encontrada, retorna 200 OK com o AvaliacaoDTO no corpo
                .orElse(ResponseEntity.notFound().build()); // Se não encontrada, retorna 404 Not Found build() serve para construir a resposta HTTP sem corpo
    }

    //Deletar avaliação
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAvaliacao(@PathVariable Long id) {
        avaliacaoService.deletarAvaliacao(id);
        return ResponseEntity.noContent().build();
    }

    // Atualizar avaliação
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AvaliacaoDTO> atualizarAvaliacao(@PathVariable Long id, @RequestBody AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoDTO atualizadoAvaliacaoDTO = avaliacaoService.atualizarAvaliacao(id, avaliacaoDTO);
        return ResponseEntity.ok(atualizadoAvaliacaoDTO);
    }
}
