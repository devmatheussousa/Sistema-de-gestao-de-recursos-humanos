package com.rh.demo.repositories;

import com.rh.demo.model.entites.EntrevistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrevistaRepository extends JpaRepository<EntrevistaEntity, Long> {
}
