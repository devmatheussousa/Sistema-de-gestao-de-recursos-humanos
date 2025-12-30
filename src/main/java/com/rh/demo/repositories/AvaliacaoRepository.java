package com.rh.demo.repositories;

import com.rh.demo.model.entites.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta classe é um repositório Spring, responsável por interagir com o banco de dados.
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
}
