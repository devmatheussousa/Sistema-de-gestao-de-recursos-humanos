package com.rh.demo.repositories;

import com.rh.demo.model.entites.UsuarioLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioLoginRepository extends JpaRepository<UsuarioLoginEntity, Long> {
}
