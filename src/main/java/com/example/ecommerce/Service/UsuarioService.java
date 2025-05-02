package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.LoginDTO;
import com.example.ecommerce.Dto.UsuarioDTO;
import com.example.ecommerce.Model.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarUsuarios();
    Usuario registrarUsuario(UsuarioDTO usuarioDTO);
    void eliminarUsuario(@NotBlank Long id);
    UsuarioDTO buscarUsuarioPorId(@NotBlank Long id);
    UsuarioDTO buscarUsuarioPorEmail(@NotBlank String email);
    String autenticarUsuario(LoginDTO loginDTO);
    String generarToken(Usuario usuario);
    UsuarioDTO convertirADTO(Usuario usuario);
}
