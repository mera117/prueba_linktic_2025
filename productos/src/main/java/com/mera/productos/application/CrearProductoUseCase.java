package com.mera.productos.application;

import com.mera.productos.application.dto.CrearProductoDTO;
import com.mera.productos.domain.model.Producto;
import com.mera.productos.domain.port.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CrearProductoUseCase
{
    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    public Producto ejecutar(CrearProductoDTO dto) {
        Producto newProduct = new Producto(null, dto.getNombre(), dto.getValorUnidad(), dto.getDetalle(), LocalDateTime.now());
        return productoRepository.save(newProduct);
    }

}
