package tienda.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductoDTO {
	
	private long idProducto ;
	private String nombre;
	private double precio ;
	private int stock ;
	private CategoriaDTO categoria;
	
	
	
	
	
}
