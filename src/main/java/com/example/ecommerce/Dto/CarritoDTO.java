package com.example.ecommerce.Dto;


import com.example.ecommerce.Model.ItemCarrito;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarritoDTO {
    private Long id;
    private Long idUsuario;
    private List<ItemCarrito> items;

    public CarritoDTO() {
    }

    public CarritoDTO(Long id, Long idUsuario, List<ItemCarrito> items) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.items = items;
    }
}
