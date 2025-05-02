package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.ProductoDTO;
import com.example.ecommerce.Model.Producto;
import com.example.ecommerce.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Operaciones relacionadas con productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    @Operation(summary = "Listar todos los productos", description = "Obtiene una lista de todos los productos")
    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping
    @Operation(summary = "Guardar un nuevo producto", description = "Crea un nuevo producto y devuelve el producto creado")
    public ResponseEntity<Producto> guardarProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = productoService.guardarProducto(productoDTO);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un producto por ID", description = "Obtiene un producto específico por su ID")
    public ResponseEntity<ProductoDTO> buscarProductoPorId(@PathVariable Long id) {
        ProductoDTO productoDTO = productoService.buscarProductoPorId(id);
        return ResponseEntity.ok(productoDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto por ID", description = "Elimina un producto específico por su ID")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}

