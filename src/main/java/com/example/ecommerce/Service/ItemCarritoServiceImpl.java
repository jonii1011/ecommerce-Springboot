package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Dto.ItemCarritoDTO;
import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Model.ItemCarrito;
import com.example.ecommerce.Repository.ItemCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemCarritoServiceImpl implements ItemCarritoService {

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    @Override
    public List<ItemCarritoDTO> listarItemsCarrito(Long idCarrito) {
        List<ItemCarrito> items = itemCarritoRepository.findByCarritoId(idCarrito);
        return items.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemCarrito crearItemCarrito(ItemCarritoDTO itemCarritodto) {
        ItemCarrito itemCarrito = new ItemCarrito();
        itemCarrito.setCarrito(itemCarritodto.getCarrito());
        itemCarrito.setProducto(itemCarritodto.getProducto());
        itemCarrito.setCantidad(itemCarritodto.getCantidad());
        return itemCarritoRepository.save(itemCarrito);
    }

    @Override
    public ItemCarritoDTO obtenerItemCarritoPorId(Long id) {
        ItemCarrito itemCarrito = itemCarritoRepository.findById(id).get();
        return convertirADTO(itemCarrito);
    }

    @Override
    public void eliminarItemCarrito(Long id) {
        itemCarritoRepository.deleteById(id);
    }

    @Override
    public ItemCarritoDTO convertirADTO(ItemCarrito itemCarrito) {
        ItemCarritoDTO dto = new ItemCarritoDTO();
        dto.setCarrito(itemCarrito.getCarrito());
        dto.setProducto(itemCarrito.getProducto());
        dto.setCantidad(itemCarrito.getCantidad());
        return dto;
    }
}
