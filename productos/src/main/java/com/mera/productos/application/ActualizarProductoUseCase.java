package com.mera.productos.application;

import com.mera.productos.application.dto.ActualizarProductoDTO;
import com.mera.productos.domain.model.Producto;
import com.mera.productos.domain.port.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Component
public class ActualizarProductoUseCase {

    @Autowired
    private ProductoRepository repository;

        public Producto updateProduct(Long id, ActualizarProductoDTO dto) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));

        producto.setNombre(dto.getNombre());
        producto.setValorUnidad(BigDecimal.valueOf(dto.getValorUnidad()));
        producto.setDetalle(dto.getDetalle());

        return repository.save(producto);
    }
}
