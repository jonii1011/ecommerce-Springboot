package com.example.ecommerce.Dto;

import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.Producto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarritoDTO {
    private Long id;
    private Carrito carrito;
    private Producto producto;
    private Integer cantidad;

    public ItemCarritoDTO() {
    }

    public ItemCarritoDTO(Long id, Carrito carrito, Producto producto, Integer cantidad) {
        this.id = id;
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
