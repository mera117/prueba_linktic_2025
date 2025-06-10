package com.mera.productos.infrastructure.controller;


import com.mera.productos.application.*;
import com.mera.productos.application.dto.ActualizarProductoDTO;
import com.mera.productos.application.dto.CrearProductoDTO;
import com.mera.productos.domain.model.Producto;
import com.mera.productos.infrastructure.controller.response.JsonApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private CrearProductoUseCase crearProductoUseCase;
    @Autowired
    private ObtenerProductoPorIdUseCase obtenerProductoPorIdUseCase;
    @Autowired
    private ActualizarProductoUseCase actualizarProductoUseCase;
    @Autowired
    private EliminarProductoUseCase eliminarProductoUseCase;
    @Autowired
    private ListarProductosPaginadosUseCase listarProductosPaginadosUseCase;


    @PostMapping
    public ResponseEntity<JsonApiResponse> crearProducto(@RequestBody CrearProductoDTO dto) {
        Producto creado = crearProductoUseCase.ejecutar(dto);

        JsonApiResponse response = JsonApiResponse.of("producto", creado.getId(), creado);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonApiResponse> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = obtenerProductoPorIdUseCase.findProduct(id);
        JsonApiResponse response = JsonApiResponse.of("producto", producto.getId(), producto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JsonApiResponse> actualizarProducto(@PathVariable Long id, @RequestBody ActualizarProductoDTO dto) {
        Producto actualizado = actualizarProductoUseCase.updateProduct(id, dto);
        JsonApiResponse response = JsonApiResponse.of("producto", actualizado.getId(), actualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        eliminarProductoUseCase.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<JsonApiResponse> listarProductos(
    ) {
        List<Producto> productos = listarProductosPaginadosUseCase.findAllProduct();
        JsonApiResponse response = JsonApiResponse.of("productos", null, productos);
        return ResponseEntity.ok(response);
    }
}
