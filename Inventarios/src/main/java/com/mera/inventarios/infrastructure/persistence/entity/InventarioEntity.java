package com.mera.inventarios.infrastructure.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventarios")
@Data
public class InventarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "producto_id", nullable = false, unique = true)
    private Long productoId;

    @Column(name = "cantidad_entrada")
    private int cantidadEntrada;

    @Column(name = "cantidad_salida")
    private int cantidadSalida;

    @Column(name = "cantidad_total")
    private int cantidadTotal;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

}
