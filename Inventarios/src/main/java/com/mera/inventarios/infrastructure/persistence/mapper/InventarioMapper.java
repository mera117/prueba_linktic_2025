package com.mera.inventarios.infrastructure.persistence.mapper;


import com.mera.inventarios.domain.model.Inventario;
import com.mera.inventarios.infrastructure.persistence.entity.InventarioEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InventarioMapper {

    public InventarioEntity toEntity(Inventario inventario) {
        InventarioEntity entity = new InventarioEntity();
        entity.setId(inventario.getId());
        entity.setProductoId(inventario.getProductoId());
        entity.setCantidadEntrada(inventario.getCantidadEntrada());
        entity.setCantidadSalida(inventario.getCantidadSalida());
        entity.setCantidadTotal(inventario.getCantidadTotal());
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }


    public Inventario toDomain(InventarioEntity entity) {
        return new Inventario(
                entity.getId(),
                entity.getProductoId(),
                entity.getCantidadEntrada(),
                entity.getCantidadSalida(),
                entity.getCantidadTotal(),
                entity.getFechaCreacion()
        );
    }


}
