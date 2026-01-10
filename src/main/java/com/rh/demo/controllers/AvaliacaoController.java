package com.rh.demo.controllers;

import com.rh.demo.model.DTOs.AvaliacaoDTOs.AvaliacaoDTO;
import com.rh.demo.model.DTOs.AvaliacaoDTOs.PageResponse;
import com.rh.demo.services.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;


    //criar avaliação
    @PostMapping("/criar")
    public ResponseEntity<AvaliacaoDTO> criarAvaliacao(@RequestBody @Valid AvaliacaoDTO novaAvaliacaoDTO){
       AvaliacaoDTO avaliacaoDTO = avaliacaoService.criarAvaliacao(novaAvaliacaoDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoDTO);
    }

    //Listar avaliações com paginação
    @GetMapping("/paginated")
    public ResponseEntity<PageResponse<AvaliacaoDTO>> listarAvaliacoes(@RequestParam(defaultValue = "0")  int page,
                                                                       @RequestParam(defaultValue = "10")  int size){
       return ResponseEntity.ok(avaliacaoService.listarAvaliacoes(page, size));
    }

    //Listar avaliacoes sem paginação
    @GetMapping("/all")
    public ResponseEntity<List<AvaliacaoDTO>> listarAvaliacoesSemPaginacao(){
        return ResponseEntity.ok(avaliacaoService.listarAvaliacoesSemPaginacao());
    }

    //Buscar por Id
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoDTO> buscarAvaliacaoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(avaliacaoService.buscarAvaliacaoPorId(id));
    }

    //Deletar avaliação
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarAvaliacao(@PathVariable Long id) {
        avaliacaoService.deletarAvaliacao(id);
        return ResponseEntity.noContent().build();
    }

    // Atualizar avaliação
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AvaliacaoDTO> atualizarAvaliacao(@PathVariable Long id,
                                                           @RequestBody @Valid AvaliacaoDTO avaliacaoDTO) {
        AvaliacaoDTO atualizadoAvaliacaoDTO = avaliacaoService.atualizarAvaliacao(id, avaliacaoDTO);
        return ResponseEntity.ok(atualizadoAvaliacaoDTO);
    }
}
