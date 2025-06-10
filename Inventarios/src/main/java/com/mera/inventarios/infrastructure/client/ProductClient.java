package com.mera.inventarios.infrastructure.client;

import com.mera.inventarios.infrastructure.client.dto.ProductoAttributes;

import java.util.Optional;

public interface ProductClient {

    Optional<ProductoAttributes> obtenerDetalleProducto(Long productoId);
}
