package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.CarritoDTO;
import com.example.ecommerce.Model.Carrito;
import com.example.ecommerce.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<CarritoDTO> listarCarritos() {
        return carritoService.obtenerCarritos();
    }

    @PostMapping
    public ResponseEntity<CarritoDTO> crearCarrito(@RequestBody CarritoDTO carritoDTO) {
        CarritoDTO nuevoCarritoDTO = carritoService.crearCarrito(carritoDTO);  // Usa `carritoDTO` aquí
        return ResponseEntity.ok(nuevoCarritoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarritoDTO> buscarCarritoPorId(@PathVariable Long id) {
        CarritoDTO carritoDTO = carritoService.obtenerCarritoPorId(id);
        return ResponseEntity.ok(carritoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}
