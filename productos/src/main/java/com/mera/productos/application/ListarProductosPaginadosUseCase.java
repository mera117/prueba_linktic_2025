package com.mera.productos.application;


import com.mera.productos.domain.model.Producto;
import com.mera.productos.domain.port.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarProductosPaginadosUseCase {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> findAllProduct() {
        return repository.listProduct();
    }
}
