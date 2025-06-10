package com.mera.productos.infrastructure.persistence.mapper;

import com.mera.productos.domain.model.Producto;
import com.mera.productos.infrastructure.persistence.entity.ProductoEntity;
import org.springframework.stereotype.Component;


@Component
public class ProductoMapper {
    public ProductoEntity toEntity(Producto producto) {
        ProductoEntity entity = new ProductoEntity();
        entity.setId(producto.getId());
        entity.setNombre(producto.getNombre());
        entity.setValorUnidad(producto.getValorUnidad());
        entity.setDetalle(producto.getDetalle());
        entity.setFechaCreacion(producto.getFechaCreacion());
        return entity;
    }

    public Producto toModel(ProductoEntity entity) {
        return new Producto(
                entity.getId(),
                entity.getNombre(),
                entity.getValorUnidad(),
                entity.getDetalle(),
                entity.getFechaCreacion()
        );
    }
}
