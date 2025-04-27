package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingAndCategoriaContaining(String nombre, String categoria);
}
