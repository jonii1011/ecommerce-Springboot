package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Model.Carrito;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

public interface CarritoService {

    List<CarritoDTO> obtenerCarritos();
    CarritoDTO crearCarrito(CarritoDTO carritoDTO);
    CarritoDTO obtenerCarritoPorId(Long id);
    void eliminarCarrito(@NotBlank Long id);
    CarritoDTO convertirADTO(Carrito carrito);
}
