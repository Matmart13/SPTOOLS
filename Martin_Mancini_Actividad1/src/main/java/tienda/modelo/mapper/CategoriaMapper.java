package tienda.modelo.mapper;

import tienda.modelo.dto.CategoriaDTO;
import tienda.modelo.entities.Categoria;

public class CategoriaMapper {


    public static CategoriaDTO entityToDto(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        return dto;
    }

    public static Categoria dtoToEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(dto.getIdCategoria());
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        return categoria;
    }

	
}
