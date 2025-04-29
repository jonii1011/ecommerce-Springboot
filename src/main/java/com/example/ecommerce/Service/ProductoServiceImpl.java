package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.ProductoDTO;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .filter(producto -> !producto.isBorrado()) // Filtra los productos borrados
                .map(this::convertirAProductoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO buscarProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id).get();
        return convertirAProductoDTO(producto);
    }

    @Override
    @Transactional
    public Producto guardarProducto(@Valid ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setSku(productoDTO.getSku());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setStock(productoDTO.getStock());
        producto.setImagenURL(productoDTO.getImagenURl());
        producto.setFechaElaboracion(productoDTO.getFechaElaboracion());
        producto.setBorrado(productoDTO.isBorrado());
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow();
        producto.setBorrado(true);
        productoRepository.save(producto);
    }

    @Override
    public ProductoDTO convertirAProductoDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setSku(producto.getSku());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setImagenURl(producto.getImagenURL());
        dto.setCategoria(producto.getCategoria());
        dto.setFechaElaboracion(producto.getFechaElaboracion());
        producto.setBorrado(producto.isBorrado());
        return dto;
    }
}

