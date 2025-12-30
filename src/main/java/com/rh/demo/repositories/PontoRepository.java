package com.rh.demo.repositories;

import com.rh.demo.model.entites.PontoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends JpaRepository<PontoEntity, Long> {
}
