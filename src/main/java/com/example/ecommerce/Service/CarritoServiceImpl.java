package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<CarritoDTO> obtenerCarritos() {
        List<Carrito> carritos = carritoRepository.findAll();
        return carritos.stream().map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarritoDTO crearCarrito(CarritoDTO carritoDTO) {
        Carrito carrito = new Carrito();
        carrito.setUsuario(carritoDTO.getUsuario());
        carrito.setItems(carritoDTO.getItems());
        Carrito nuevoCarrito = carritoRepository.save(carrito);
        return convertirADTO(nuevoCarrito);  // Asegúrate de convertir el objeto `Carrito` a `CarritoDTO`
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
        dto.setUsuario(carrito.getUsuario());
        dto.setItems(carrito.getItems());
        return dto;
    }
}
