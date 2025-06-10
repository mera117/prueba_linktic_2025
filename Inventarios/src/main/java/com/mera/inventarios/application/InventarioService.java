package com.mera.inventarios.application;

import com.mera.inventarios.domain.model.Inventario;
import com.mera.inventarios.domain.model.ProductoInventarioDTO;
import com.mera.inventarios.domain.repository.InventarioRepository;
import com.mera.inventarios.infrastructure.client.ProductClient;
import com.mera.inventarios.infrastructure.client.dto.ProductoAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;


@Service
@Slf4j
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ProductClient productoClient;

    public ProductoInventarioDTO getInventory(Long productoId) {
        Inventario detalleFinal = inventarioRepository.findProductById(productoId)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        ProductoAttributes producto = productoClient.obtenerDetalleProducto(productoId)
                .orElseThrow(() -> new RuntimeException("No hay detalle del producto"));

        return new ProductoInventarioDTO(producto, detalleFinal);
    }


    public ProductoAttributes consultarDetalleDesdeProductos(Long productoId) {
        return productoClient.obtenerDetalleProducto(productoId)
                .orElseThrow(() -> new RuntimeException("No hay detalle del producto"));
    }

    public ProductoInventarioDTO registerPurchase(Long productoId, int cantidadComprada) {
        ProductoAttributes productoDetalle = productoClient.obtenerDetalleProducto(productoId)
                .orElseThrow(() -> new IllegalArgumentException("No hay detalle del producto"));

        Inventario inventario = inventarioRepository.findProductById(productoId)
                .orElseGet(() -> {
                    Inventario nuevo = new Inventario();
                    nuevo.setProductoId(productoId);
                    nuevo.setCantidadEntrada(0);
                    nuevo.setCantidadTotal(0);
                    return nuevo;
                });
        log.info("Guardando inventario. ID existente: {}", inventario.getId());
        inventario.reducirCantidad(cantidadComprada);
        inventario.setCantidadSalida(cantidadComprada);
        inventario.setFechaCreacion(LocalDateTime.now());

        Inventario registroFinal = inventarioRepository.saveProduct(inventario);

        log.info("Evento: Se actualizó inventario del producto ID {}. Nueva cantidad: {}",
                productoId, registroFinal.getCantidadTotal());

        return new ProductoInventarioDTO(productoDetalle, registroFinal);
    }

    public ProductoInventarioDTO recordIncome(Long productoId, int cantidad) {
        ProductoAttributes productoDetalle = productoClient.obtenerDetalleProducto(productoId)
                .orElseThrow(() -> new IllegalArgumentException("No hay detalle del producto"));

        Inventario inventario = inventarioRepository.findProductById(productoId)
                .orElseGet(() -> {
                    Inventario nuevo = new Inventario();
                    nuevo.setProductoId(productoId);
                    nuevo.setCantidadSalida(0);
                    nuevo.setCantidadTotal(0);
                    return nuevo;
                });

        inventario.aumentarCantidad(cantidad);
        inventario.setFechaCreacion(LocalDateTime.now());

        Inventario registroFinal = inventarioRepository.saveProduct(inventario);

        log.info("Ingreso registrado para producto ID {}. Nueva cantidad: {}", productoId, registroFinal.getCantidadTotal());

        return new ProductoInventarioDTO(productoDetalle, registroFinal);
    }


}
