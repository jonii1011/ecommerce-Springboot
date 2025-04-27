package com.example.ecommerce.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    private String sku;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagenURL;
    private String categoria;
    private Date fechaElaboracion = new Date();
    private boolean borrado;

    public Producto() {
    }

    public Producto(Long id, String nombre, String sku, String descripcion, Double precio, Integer stock, String imagenURL, String categoria, Date fechaElaboracion, boolean borrado) {
        this.id = id;
        this.nombre = nombre;
        this.sku = sku;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagenURL = imagenURL;
        this.categoria = categoria;
        this.fechaElaboracion = fechaElaboracion;
        this.borrado = borrado;
    }
}
