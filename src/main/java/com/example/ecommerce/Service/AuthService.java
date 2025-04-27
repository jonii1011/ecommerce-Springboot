package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.UsuarioDTO;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Método para registrar un nuevo usuario
    public Usuario registrarUsuario(@Valid UsuarioDTO usuarioDTO) {
        // Verificar si el usuario ya existe
        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            throw new RuntimeException("El correo electrónico ya está en uso.");
        }

        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(encriptarPassword(usuarioDTO.getPassword()));
        // Aquí puedes agregar otros campos del usuario si es necesario

        return usuarioRepository.save(usuario);
    }

    // Método para autenticar un usuario
    public Usuario autenticarUsuario(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

        // Verificar la contraseña
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta.");
        }

        return usuario; // O puedes devolver un token JWT si lo estás usando
    }

    // Método para encriptar la contraseña
    private String encriptarPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
