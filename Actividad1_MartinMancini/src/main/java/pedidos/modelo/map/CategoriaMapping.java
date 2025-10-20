package pedidos.modelo.map;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import pedidos.modelo.dto.CategoriaDTO;
import pedidos.modelo.entities.Categoria;

@Component

public class CategoriaMapping {
    public CategoriaMapping() {
        // Solo inicialización segura
    }
	  // --- Entidad → DTO ---
    public CategoriaDTO toDTO(Categoria categoria) {
        if (categoria == null) {
            return null;
        }
        return new CategoriaDTO(
                categoria.getIdCategoria(),
                categoria.getNombre(),
                categoria.getDescripcion()
        );
    }

    // --- DTO → Entidad ---
    public Categoria toEntity(CategoriaDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Categoria(
                dto.getIdCategoria(),
                dto.getNombre(),
                dto.getDescripcion()
        );
    }

    // --- Lista de entidades → Lista de DTOs ---
    public List<CategoriaDTO> toDTOList(List<Categoria> categorias) {
        return categorias.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // --- Lista de DTOs → Lista de entidades ---
    public List<Categoria> toEntityList(List<CategoriaDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
	
	
	
