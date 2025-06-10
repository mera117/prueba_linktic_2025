package com.mera.productos.application.dto;

import lombok.Data;

@Data
public class ActualizarProductoDTO {

    private String nombre;
    private Double valorUnidad;
    private String detalle;
}
