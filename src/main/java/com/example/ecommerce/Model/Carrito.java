package com.example.ecommerce.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario;

    @OneToMany(mappedBy = "carrito")
    private List<ItemCarrito> items;

    public Carrito() {
    }

    public Carrito(Long id, Long idUsuario, List<ItemCarrito> items) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.items = items;
    }
}
