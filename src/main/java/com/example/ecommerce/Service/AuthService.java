package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.UsuarioDTO;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import javax.crypto.SecretKey;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Cambiado a PasswordEncoder

    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) {
        // Verificar si el usuario ya existe
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioDTO.getEmail());

        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("El correo electrónico ya está en uso.");
        }

        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setRol(usuarioDTO.getRol());
        usuario.setPassword(encriptarPassword(usuarioDTO.getPassword())); // Asegúrate de encriptar la contraseña

        return usuarioRepository.save(usuario); // Guarda el usuario en el repositorio
    }


    public String autenticarUsuario(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));

        // Verificar la contraseña
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta.");
        }

        // Generar y devolver el token JWT
        return generarToken(usuario);
    }

    @Autowired
    private SecretKey jwtSecretKey; // Inyecta la clave desde JwtConfig

    // Método para generar el token JWT
    private String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .signWith(jwtSecretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    // Método para encriptar la contraseña
    private String encriptarPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
