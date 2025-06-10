package com.mera.inventarios.domain.model;

import com.mera.inventarios.infrastructure.client.dto.ProductoAttributes;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ProductoInventarioDTO {
    private Long id;
    private String nombre;
    private Integer valorUnidad;
    private String detalle;
    private LocalDateTime fechaCreacion;

    private int cantidadEntrada;
    private int cantidadSalida;
    private int cantidadTotal;

    public ProductoInventarioDTO() {}

    public ProductoInventarioDTO(Long id, String nombre, Integer valorUnidad, String detalle,
                                 LocalDateTime fechaCreacion, int cantidadEntrada,
                                 int cantidadSalida, int cantidadTotal) {
        this.id = id;
        this.nombre = nombre;
        this.valorUnidad = valorUnidad;
        this.detalle = detalle;
        this.fechaCreacion = fechaCreacion;
        this.cantidadEntrada = cantidadEntrada;
        this.cantidadSalida = cantidadSalida;
        this.cantidadTotal = cantidadTotal;
    }

    public ProductoInventarioDTO(ProductoAttributes producto, Inventario inventario) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.valorUnidad = producto.getValorUnidad();
        this.detalle = producto.getDetalle();
        this.fechaCreacion = producto.getFechaCreacion();
        this.cantidadEntrada = inventario.getCantidadEntrada();
        this.cantidadSalida = inventario.getCantidadSalida();
        this.cantidadTotal = inventario.getCantidadTotal();
    }

}
