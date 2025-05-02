package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Service.CarritoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
@Tag(name = "Carritos", description = "Operaciones relacionadas con carritos de compra")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    @Operation(summary = "Listar todos los carritos", description = "Obtiene una lista de todos los carritos")
    public List<CarritoDTO> listarCarritos() {
        return carritoService.obtenerCarritos();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo carrito", description = "Crea un nuevo carrito y devuelve el carrito creado")
    public ResponseEntity<CarritoDTO> crearCarrito(@RequestBody CarritoDTO carritoDTO) {
        CarritoDTO nuevoCarritoDTO = carritoService.crearCarrito(carritoDTO);
        return ResponseEntity.ok(nuevoCarritoDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un carrito por ID", description = "Obtiene un carrito específico por su ID")
    public ResponseEntity<CarritoDTO> buscarCarritoPorId(@PathVariable Long id) {
        CarritoDTO carritoDTO = carritoService.obtenerCarritoPorId(id);
        return ResponseEntity.ok(carritoDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un carrito por ID", description = "Elimina un carrito específico por su ID")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}

