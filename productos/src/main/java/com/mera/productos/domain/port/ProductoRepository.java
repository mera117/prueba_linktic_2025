package com.mera.productos.domain.port;

import com.mera.productos.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {


    Producto save(Producto producto);

    Optional<Producto> findById(Long id);

    List<Producto> listProduct();

    void deleteProduct(Long id);
}
