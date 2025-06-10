package com.mera.productos.infrastructure.persistence;

import com.mera.productos.infrastructure.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
