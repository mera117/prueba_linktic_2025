package com.mera.inventarios.infrastructure.controller;


import com.mera.inventarios.application.InventarioService;
import com.mera.inventarios.domain.model.Inventario;
import com.mera.inventarios.domain.model.ProductoInventarioDTO;
import com.mera.inventarios.infrastructure.client.dto.ProductoAttributes;
import com.mera.inventarios.infrastructure.controller.response.JsonApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
@Tag(name = "Inventario", description = "Operaciones del inventario")
public class InventarioController {

    @Autowired
    private InventarioService service;

    @GetMapping("/{productoId}")
    @Operation(summary = "Obtener el inventario de un producto")
    public ResponseEntity<JsonApiResponse> obtenerInventario(@PathVariable Long productoId) {
        ProductoInventarioDTO inventario = service.getInventory(productoId);
        JsonApiResponse response = JsonApiResponse.of("Inventario",  UUID.randomUUID(), inventario);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productoId}/detalle")
    @Operation(summary = "Consultar la cantidad actual del producto desde el microservicio de productos")
    public ResponseEntity<JsonApiResponse> consultarCantidadProducto(@PathVariable Long productoId) {
        ProductoAttributes detalleProducto = service.consultarDetalleDesdeProductos(productoId);
        JsonApiResponse response = JsonApiResponse.of("Detalle-Producto", UUID.randomUUID(), detalleProducto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/compra")
    @Operation(summary = "Registrar una compra (disminuye inventario)")
    public ResponseEntity<JsonApiResponse> registrarCompra(
            @RequestParam Long productoId,
            @RequestParam int cantidad
    ) {
        ProductoInventarioDTO inventario = service.registerPurchase(productoId, cantidad);
        JsonApiResponse response = JsonApiResponse.of("Registrar una compra", UUID.randomUUID(), inventario);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/ingreso")
    @Operation(summary = "Registrar un ingreso (aumenta inventario)")
    public ResponseEntity<JsonApiResponse> registrarIngreso(
            @RequestParam Long productoId,
            @RequestParam int cantidad
    ) {
        ProductoInventarioDTO inventario= service.recordIncome(productoId, cantidad);
        JsonApiResponse response = JsonApiResponse.of("Registrar un ingreso", UUID.randomUUID(), inventario);
        return ResponseEntity.ok(response);
    }

}
