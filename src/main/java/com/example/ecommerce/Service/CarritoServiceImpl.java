package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public Carrito crearCarrito(CarritoDTO carritoDTO) {
        Carrito carrito = new Carrito();
        carrito.setIdUsuario(carritoDTO.getIdUsuario());
        carrito.setItems(carritoDTO.getItems());
        return carritoRepository.save(carrito);
    }

    @Override
    public CarritoDTO obtenerCarritoPorId(Long id) {
        Carrito carrito = carritoRepository.findById(id).get();
        return convertirADTO(carrito);
    }

    @Override
    public void eliminarCarrito(Long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public CarritoDTO convertirADTO(Carrito carrito) {
        CarritoDTO dto = new CarritoDTO();
        dto.setIdUsuario(carrito.getIdUsuario());
        dto.setItems(carrito.getItems());
        return dto;
    }
}
