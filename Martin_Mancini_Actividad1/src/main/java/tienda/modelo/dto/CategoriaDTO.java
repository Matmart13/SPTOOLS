package tienda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CategoriaDTO {
	
	private long idCategoria;
	private String nombre;
	private String descripcion;
	
	
	
}
