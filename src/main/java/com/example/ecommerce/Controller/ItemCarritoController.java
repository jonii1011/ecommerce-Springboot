package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.ItemCarritoDTO;
import com.example.ecommerce.Model.ItemCarrito;
import com.example.ecommerce.Service.ItemCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-carrito")
public class ItemCarritoController {

    @Autowired
    private ItemCarritoService itemCarritoService;

    @GetMapping("/{carritoId}")
    public List<ItemCarritoDTO> listarItems(@PathVariable Long carritoId) {
        return itemCarritoService.listarItemsCarrito(carritoId);
    }

    @PostMapping
    public ResponseEntity<ItemCarrito> agregarItem(@RequestBody ItemCarritoDTO itemCarrito) {
        ItemCarrito nuevoItem = itemCarritoService.crearItemCarrito(itemCarrito);
        return ResponseEntity.ok(nuevoItem);
    }

    @GetMapping("/{carritoId}/item/{id}")
    public ResponseEntity<ItemCarritoDTO> buscarItemPorId(@PathVariable Long carritoId, @PathVariable Long id) {
        ItemCarritoDTO itemCarrito = itemCarritoService.obtenerItemCarritoPorId(id);
        return ResponseEntity.ok(itemCarrito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        itemCarritoService.eliminarItemCarrito(id);
        return ResponseEntity.noContent().build();
    }
}


