package com.mera.productos.infrastructure.persistence;

import com.mera.productos.domain.model.Producto;
import com.mera.productos.domain.port.ProductoRepository;
import com.mera.productos.infrastructure.persistence.entity.ProductoEntity;
import com.mera.productos.infrastructure.persistence.mapper.ProductoMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaProductoRepository implements ProductoRepository {

    private final SpringDataProductoRepository jpa;
    private final ProductoMapper mapper;

    public JpaProductoRepository(SpringDataProductoRepository jpa, ProductoMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }

    @Override
    public Producto save(Producto producto) {
        ProductoEntity entity = mapper.toEntity(producto);
        ProductoEntity saved = jpa.save(entity);
        return mapper.toModel(saved);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return jpa.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Producto> listProduct() {
        return jpa.findAll()
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        jpa.deleteById(id);
    }
}
