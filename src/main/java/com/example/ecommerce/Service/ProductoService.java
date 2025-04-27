package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.ProductoDTO;
import com.example.ecommerce.Model.Producto;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listarProductos();
    ProductoDTO buscarProductoPorId(@NotBlank Long id);
    Producto guardarProducto(ProductoDTO productoDTO);
    void eliminarProducto(@NotBlank Long id);
    ProductoDTO convertirAProductoDTO(Producto producto);
}
