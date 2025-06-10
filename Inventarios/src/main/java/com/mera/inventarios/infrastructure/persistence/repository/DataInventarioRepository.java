package com.mera.inventarios.infrastructure.persistence.repository;

import com.mera.inventarios.infrastructure.persistence.entity.InventarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface DataInventarioRepository extends JpaRepository<InventarioEntity, Long> {
    Optional<InventarioEntity> findTopByProductoIdOrderByIdDesc(Long productoId);
}
