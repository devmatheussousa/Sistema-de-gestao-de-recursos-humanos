package com.rh.demo.repositories;

import com.rh.demo.model.entites.TreinamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinamentoRepository extends JpaRepository<TreinamentoEntity, Long> {
}
