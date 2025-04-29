package com.example.ecommerce.Controller;

import com.example.ecommerce.Dto.LoginDTO;
import com.example.ecommerce.Dto.UsuarioDTO;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Service.AuthService;
import com.example.ecommerce.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthService authService;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = authService.registrarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<String> autenticarUsuario(@RequestBody LoginDTO loginDTO) {
        String token = authService.autenticarUsuario(loginDTO.getEmail(), loginDTO.getPassword());
        return ResponseEntity.ok(token);
    }
}
