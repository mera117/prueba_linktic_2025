package com.mera.inventarios.infrastructure.client.dto;


import lombok.Data;

@Data
public class ProductoData {
    private String type;
    private Long id;
    private ProductoAttributes attributes;
}
