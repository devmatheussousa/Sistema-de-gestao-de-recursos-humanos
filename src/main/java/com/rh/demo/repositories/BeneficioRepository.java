package com.rh.demo.repositories;

import com.rh.demo.model.entites.BeneficioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficioRepository extends JpaRepository<BeneficioEntity, Long> {
}
