package com.mera.inventarios.domain.model;

import com.mera.inventarios.infrastructure.client.dto.ProductoAttributes;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Data
public class Inventario {
    private Long id;
    private Long productoId;
    private int cantidadEntrada;
    private int cantidadSalida;
    private int cantidadTotal;
    private LocalDateTime fechaCreacion;

    public Inventario(Long id,Long productoId, int cantidadEntrada, int cantidadSalida, int cantidadTotal, LocalDateTime fechaCreacion) {
        this.id=id;
        this.productoId = productoId;
        this.cantidadEntrada = cantidadEntrada;
        this.cantidadSalida = cantidadSalida;
        this.cantidadTotal = cantidadTotal;
        this.fechaCreacion = fechaCreacion;
    }

    public Inventario() {

    }

    public void reducirCantidad(int cantidad) {
        if (cantidad > cantidadTotal) {
            throw new IllegalArgumentException("Stock insuficiente");
        }
        this.cantidadTotal -= cantidad;
    }

    public void aumentarCantidad(int cantidad) {
        this.cantidadTotal += cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventario)) return false;
        Inventario that = (Inventario) o;
        return Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId);
    }
}
