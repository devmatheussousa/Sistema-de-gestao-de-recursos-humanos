package com.rh.demo.repositories;

import com.rh.demo.model.entites.RecrutamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecrutamentoRepository extends JpaRepository<RecrutamentoEntity, Long> {
}
