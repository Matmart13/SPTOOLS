package pedidos.modelo.map;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import pedidos.modelo.dto.UsuarioDTO;
import pedidos.modelo.entities.Usuario;
@Component
public class UsuarioMapping {

	 // --- Entidad → DTO ---
    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getFechaRegistro()
        );
    }

    // --- DTO → Entidad ---
    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setFechaRegistro(dto.getFechaRegistro());
        usuario.setRol("CLIENTE");
        return usuario;
    }

    // --- Lista de Entidades → Lista de DTOs ---
    public List<UsuarioDTO> toDTOList(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // --- Lista de DTOs → Lista de Entidades ---
    public List<Usuario> toEntityList(List<UsuarioDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
    
}
	

