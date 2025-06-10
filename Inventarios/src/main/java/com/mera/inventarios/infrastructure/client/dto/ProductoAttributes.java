package com.mera.inventarios.infrastructure.client.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductoAttributes {
    private Long id;
    private String nombre;
    private Integer valorUnidad;
    private String detalle;
    private LocalDateTime fechaCreacion;
}
