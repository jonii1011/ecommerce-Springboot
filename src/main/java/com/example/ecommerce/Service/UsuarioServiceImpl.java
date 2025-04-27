package com.example.ecommerce.Service;

import com.example.ecommerce.Dto.LoginDTO;
import com.example.ecommerce.Dto.UsuarioDTO;
import com.example.ecommerce.Model.Usuario;
import com.example.ecommerce.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        return usuarioRepository.save(usuario); // Guarda el usuario en el repositorio
    }

    @Override
    public void eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Usuario no encontrado con ID: " + id);
        }
    }

    @Override
    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        return convertirADTO(usuario);
    }

    @Override
    public String autenticarUsuario(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + loginDTO.getEmail()));

        // Aquí debes verificar el hash de la contraseña
        if (usuario.getPassword().equals(loginDTO.getPassword())) { // Usa hashing para comparar
            return generarToken(usuario);
        } else {
            throw new BadCredentialsException("Credenciales incorrectas");
        }
    }

    @Override
    public String generarToken(Usuario usuario) {
        // Implementación para generar un token JWT
        return "token"; // Debes implementar la lógica real aquí
    }

    @Override
    public UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        return dto; // Asegúrate de retornar el DTO
    }
}

