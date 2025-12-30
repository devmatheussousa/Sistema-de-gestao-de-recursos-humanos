package com.rh.demo.repositories;

import com.rh.demo.model.entites.FeriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeriasRepository extends JpaRepository<FeriasEntity, Long> {
}
