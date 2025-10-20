package pedidos.modelo.map;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import pedidos.modelo.dto.ProductoDTO;
import pedidos.modelo.entities.Categoria;
import pedidos.modelo.entities.Producto;
import pedidos.modelo.repository.CategoriaRepository;

@Component
public class ProductoMapping {

	 public ProductoMapping() {
	        // Solo inicialización segura
	    }
		  // --- Entidad → DTO ---
	    public ProductoDTO toDTO(Producto producto) {
	        if (producto == null) {
	            return null;
	        }
	        return new ProductoDTO(
	        		producto.getIdProducto(),
	                producto.getNombre(),
	                producto.getPrecio(),
	                producto.getStock(),
	                producto.getCategoria().getIdCategoria()
	        );
	    }

	    // --- DTO → Entidad ---
	    public Producto toEntity(ProductoDTO dto,Categoria categoria) {
	        if (dto == null) {
	            return null;
	        }
	        return new Producto(
	                dto.getIdProducto(),
	                dto.getNombre(),
	                dto.getPrecio(),
	                dto.getStock(),
	                categoria
	        );
	    }

	    // --- Lista de entidades → Lista de DTOs ---
	    public List<ProductoDTO> toDTOList(List<Producto> productos) {
	        return productos.stream()
	                .map(this::toDTO)
	                .collect(Collectors.toList());
	    }

	    // --- Lista de DTOs → Lista de entidades ---
	    public List<Producto> toEntityList(List<ProductoDTO> dtos, CategoriaRepository categoriaRepository) {
	        return dtos.stream()
	                .map(dto -> {
	                    Categoria cat = categoriaRepository.findById(dto.getCategoria())
	                            .orElseThrow(() -> new RuntimeException(
	                                    "Categoria no encontrada para id: " + dto.getCategoria()));
	                    return toEntity(dto, cat); // <-- aquí pasamos la categoría
	                })
	                .collect(Collectors.toList());
	    }

}
