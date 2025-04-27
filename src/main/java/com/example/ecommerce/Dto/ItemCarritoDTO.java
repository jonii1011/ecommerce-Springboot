package com.example.ecommerce.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarritoDTO {
    private Long id;

    @NotNull(message = "El ID del carrito es obligatorio")
    private Long idCarrito;

    @NotNull(message = "El ID del producto es obligatorio")
    private Long idProducto;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser positiva")
    private Integer cantidad;

    public ItemCarritoDTO() {
    }

    public ItemCarritoDTO(Long id, Long idCarrito, Long idProducto, Integer cantidad) {
        this.id = id;
        this.idCarrito = idCarrito;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
}
