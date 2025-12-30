package com.rh.demo.repositories;

import com.rh.demo.model.entites.FolhaPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolhaPagamentoRepository extends JpaRepository<FolhaPagamentoEntity, Long> {
}
