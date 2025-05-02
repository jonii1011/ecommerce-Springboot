package com.example.ecommerce.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductoDTO {
    private long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El SKU es obligatorio")
    private String sku;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser positivo")
    private Double precio;

    private String descripcion;
    private Integer stock;
    private String ImagenURL;
    private String categoria;
    private Date fechaElaboracion = new Date();
    private boolean borrado;

    public ProductoDTO() {
    }

    public ProductoDTO(long id, String nombre, String sku, Double precio, String descripcion, Integer stock, String imagenURL, String categoria, Date fechaElaboracion, boolean borrado) {
        this.id = id;
        this.nombre = nombre;
        this.sku = sku;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
        ImagenURL = imagenURL;
        this.categoria = categoria;
        this.fechaElaboracion = fechaElaboracion;
        this.borrado = borrado;
    }
}
