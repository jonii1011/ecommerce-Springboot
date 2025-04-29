package com.example.ecommerce.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol; // Enum para roles (USER, ADMIN)

    public Usuario() {
        this.rol = Rol.USER;
    }

    public Usuario(Long id, String nombre, String email, String password, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol != null ? rol : Rol.USER; // Asignar rol por defecto si es null
    }
}
