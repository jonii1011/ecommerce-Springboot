package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Dto.ItemCarritoDTO;
import com.example.ecommerce.Model.ItemCarrito;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

public interface ItemCarritoService {
    List<ItemCarritoDTO> listarItemsCarrito(Long idCarrito);
    ItemCarrito crearItemCarrito(ItemCarritoDTO itemCarritodto);
    ItemCarritoDTO obtenerItemCarritoPorId(Long id);
    void eliminarItemCarrito(@NotBlank Long id);
    ItemCarritoDTO convertirADTO(ItemCarrito itemCarrito);
}
