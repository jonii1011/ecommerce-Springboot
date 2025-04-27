package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Model.Carrito;
import jakarta.validation.constraints.NotBlank;
import java.util.Optional;

public interface CarritoService {

    Carrito crearCarrito(CarritoDTO carritoDTO);
    CarritoDTO obtenerCarritoPorId(Long id);
    void eliminarCarrito(@NotBlank Long id);
    CarritoDTO convertirADTO(Carrito carrito);
}
