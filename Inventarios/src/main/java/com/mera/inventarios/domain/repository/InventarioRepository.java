package com.mera.inventarios.domain.repository;

import com.mera.inventarios.domain.model.Inventario;

import java.util.Optional;


public interface InventarioRepository {
    Optional<Inventario> findProductById(Long productoId);
    Inventario saveProduct(Inventario inventario);
}
