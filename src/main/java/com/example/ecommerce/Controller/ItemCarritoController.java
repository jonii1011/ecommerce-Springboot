package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.ItemCarritoDTO;
import com.example.ecommerce.Model.ItemCarrito;
import com.example.ecommerce.Service.ItemCarritoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item-carrito")
@Tag(name = "Item Carrito", description = "Operaciones relacionadas con los items del carrito")
public class ItemCarritoController {

    @Autowired
    private ItemCarritoService itemCarritoService;

    @GetMapping("/{carritoId}")
    @Operation(summary = "Listar items del carrito", description = "Obtiene una lista de los items en el carrito especificado por ID")
    public List<ItemCarritoDTO> listarItems(@PathVariable Long carritoId) {
        return itemCarritoService.listarItemsCarrito(carritoId);
    }

    @PostMapping
    @Operation(summary = "Agregar un item al carrito", description = "Crea un nuevo item en el carrito y devuelve el item creado")
    public ResponseEntity<ItemCarrito> agregarItem(@RequestBody ItemCarritoDTO itemCarrito) {
        ItemCarrito nuevoItem = itemCarritoService.crearItemCarrito(itemCarrito);
        return ResponseEntity.ok(nuevoItem);
    }

    @GetMapping("/{carritoId}/item/{id}")
    @Operation(summary = "Buscar un item por ID", description = "Obtiene un item específico del carrito por su ID")
    public ResponseEntity<ItemCarritoDTO> buscarItemPorId(@PathVariable Long carritoId, @PathVariable Long id) {
        ItemCarritoDTO itemCarrito = itemCarritoService.obtenerItemCarritoPorId(id);
        return ResponseEntity.ok(itemCarrito);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un item del carrito", description = "Elimina un item específico del carrito por su ID")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        itemCarritoService.eliminarItemCarrito(id);
        return ResponseEntity.noContent().build();
    }
}



