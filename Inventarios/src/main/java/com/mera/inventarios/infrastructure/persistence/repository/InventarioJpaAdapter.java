package com.mera.inventarios.infrastructure.persistence.repository;

import com.mera.inventarios.domain.model.Inventario;
import com.mera.inventarios.domain.repository.InventarioRepository;
import com.mera.inventarios.infrastructure.persistence.entity.InventarioEntity;
import com.mera.inventarios.infrastructure.persistence.mapper.InventarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class InventarioJpaAdapter implements InventarioRepository {

    @Autowired
    private DataInventarioRepository dataInventarioRepository;

    @Autowired
    private InventarioMapper mapper;

    @Override
    public Optional<Inventario> findProductById(Long productoId) {
        return dataInventarioRepository.findTopByProductoIdOrderByIdDesc(productoId)
                .map(mapper :: toDomain);
    }

    @Override
    public Inventario saveProduct(Inventario inventario) {
        InventarioEntity entity = mapper.toEntity(inventario);
        InventarioEntity savedEntity = dataInventarioRepository.save(entity);
        return mapper.toDomain(savedEntity);    }

}
