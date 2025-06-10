package com.mera.productos.application;

import com.mera.productos.domain.model.Producto;
import com.mera.productos.domain.port.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ObtenerProductoPorIdUseCase {

    private final ProductoRepository repository;

    public ObtenerProductoPorIdUseCase(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto findProduct(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
    }
}
