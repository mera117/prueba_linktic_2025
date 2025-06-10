package com.mera.productos.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CrearProductoDTO {
    private String nombre;
    private BigDecimal valorUnidad;
    private String detalle;
}
