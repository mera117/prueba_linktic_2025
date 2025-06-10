package com.mera.productos.application;


import com.mera.productos.domain.model.Producto;
import com.mera.productos.domain.port.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EliminarProductoUseCase {

    @Autowired
    private ProductoRepository repository;

    public EliminarProductoUseCase(ProductoRepository repository) {
        this.repository = repository;
    }

    public void deleteProduct(Long id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
        repository.deleteProduct(producto.getId());
    }
}
