package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.ProductoDTO;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = productoService.guardarProducto(productoDTO);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarProductoPorId(@PathVariable Long id) {
        ProductoDTO productoDTO = productoService.buscarProductoPorId(id);
        return ResponseEntity.ok(productoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
