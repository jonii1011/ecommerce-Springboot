package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.LoginDTO;
import com.example.ecommerce.Dto.UsuarioDTO;
import com.example.ecommerce.Model.AuthResponse;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Repository.UsuarioRepository;
import com.example.ecommerce.Service.AuthService;
import com.example.ecommerce.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthService authService;

    @GetMapping
    @Operation(summary = "Listar todos los usuarios", description = "Obtiene una lista de todos los usuarios")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/registro")
    @Operation(summary = "Registrar un nuevo usuario", description = "Crea un nuevo usuario y devuelve el usuario creado")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = authService.registrarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un usuario por ID", description = "Obtiene un usuario específico por su ID")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario por ID", description = "Elimina un usuario específico por su ID")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    @Operation(summary = "Autenticar un usuario", description = "Autentica un usuario y devuelve un token y los detalles del usuario")
    public ResponseEntity<AuthResponse> autenticarUsuario(@RequestBody LoginDTO loginDTO) {
        String token = authService.autenticarUsuario(loginDTO.getEmail(), loginDTO.getPassword());

        // Obtén la información del usuario después de autenticar
        UsuarioDTO dto = usuarioService.buscarUsuarioPorEmail(loginDTO.getEmail());

        // Devuelve el token y la información del usuario
        AuthResponse authResponse = new AuthResponse(token, dto);
        return ResponseEntity.ok(authResponse);
    }
}

