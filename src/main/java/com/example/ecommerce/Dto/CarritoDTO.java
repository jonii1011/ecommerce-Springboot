package com.example.ecommerce.Dto;


import com.example.ecommerce.Model.ItemCarrito;
import com.example.ecommerce.Model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarritoDTO {
    private Long id;
    private Usuario usuario;
    private List<ItemCarrito> items;

    public CarritoDTO() {
    }

    public CarritoDTO(Long id, Usuario usuario, List<ItemCarrito> items) {
        this.id = id;
        this.usuario = usuario;
        this.items = items;
    }
}
