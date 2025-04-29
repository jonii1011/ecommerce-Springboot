package com.example.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // Relación ManyToOne con Carrito
    @JoinColumn(name = "carrito_id", nullable = false) // Columna que referencia a Carrito
    @JsonBackReference // Esta anotación evita que se serialice de vuelta al padre
    private Carrito carrito;
    @ManyToOne // Relación ManyToOne con Producto
    @JoinColumn(name = "producto_id", nullable = false) // Columna que referencia a Producto
    private Producto producto;
    private Integer cantidad;

    public ItemCarrito() {
    }

    public ItemCarrito(Long id, Carrito carrito, Producto producto, Integer cantidad) {
        this.id = id;
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
