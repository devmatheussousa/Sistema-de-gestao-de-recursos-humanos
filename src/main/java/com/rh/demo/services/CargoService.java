package com.rh.demo.services;

import com.rh.demo.mappers.CargoMapper;
import com.rh.demo.model.DTOs.CargoDTO;
import com.rh.demo.model.entites.CargoEntity;
import com.rh.demo.model.entites.FuncionarioEntity;
import com.rh.demo.repositories.CandidatoRepository;
import com.rh.demo.repositories.CargoRepository;
import com.rh.demo.repositories.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;
    private final CargoMapper cargoMapper;
    private final CandidatoRepository candidatoRepository;
    private final FuncionarioRepository funcionarioRepository;

    //listar todos os cargos
    @Transactional(readOnly = true) // Indica que a operação é apenas de leitura
    public List<CargoDTO> listarCargo(){
        return cargoRepository.findAll()
                .stream()
                .map(cargoMapper::toDTO)
                .toList();
    }

    //Buscar Cargo por id
    @Transactional(readOnly = true)
    public CargoDTO buscarCargoPorId(Long id){
        return cargoRepository.findById(id)
                .map(cargoMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Cargo não encontrado"));
    }

    //criar um cargo
    public CargoDTO criarCargo(CargoDTO cargoDTO){

        //Buscar o funcionario associado ao cargo
        FuncionarioEntity funcionario = funcionarioRepository
                .findById(cargoDTO.funcionarioId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));

        //Converter o DTO em entidade
        var cargoEntity = cargoMapper.toEntity(cargoDTO);
        cargoEntity.setId(null); // Garantir que o ID seja nulo para criação

        definirSalarioPorNivel(cargoEntity);

        //Definir o salario baseado no nível do cargo
        definirSalarioPorNivel(cargoEntity);


        //Associar o funcionario ao cargo
        cargoEntity.setFuncionario(funcionario);

        //Salvar o cargo no banco de dados
        CargoEntity cargoSalvo = cargoRepository.save(cargoEntity);

        //Retornar o DTO do cargo criado
        return cargoMapper.toDTO(cargoSalvo);
    }


    @Transactional
    public void deletarCargo(Long id){
        //Buscar o cargo pelo ID
        CargoEntity cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cargo não encontrado"));
        //Deletar o cargo
        cargoRepository.delete(cargo);
    }

    @Transactional
    public CargoDTO atualizarCargo(Long id, CargoDTO cargoDTO){
      CargoEntity cargo = cargoRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Cargo não encontrado"));

        //Atualizar os campos do cargo com os valores do DTO
        cargo.setNome(cargoDTO.nome());
        cargo.setDescricao(cargoDTO.descricao());
        cargo.setNivel(cargoDTO.nivel());

        FuncionarioEntity funcionario =funcionarioRepository
                .findById(cargoDTO.funcionarioId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));

        cargo.setFuncionario(funcionario);

        //Salvar o cargo atualizado no banco de dados
        CargoEntity cargoAtualizado = cargoRepository.save(cargo);

        //Retornar o DTO do cargo atualizado
        return cargoMapper.toDTO(cargoAtualizado);
    }

    private void definirSalarioPorNivel(CargoEntity cargo){
        switch (cargo.getNivel()) {
            case "JUNIOR" -> cargo.setSalario(2000.0);
            case "PLENO" -> cargo.setSalario(4000.0);
            case "SENIOR" -> cargo.setSalario(6000.0);

            default -> throw new IllegalArgumentException("Nível de cargo inválido");
        }
    }
}
