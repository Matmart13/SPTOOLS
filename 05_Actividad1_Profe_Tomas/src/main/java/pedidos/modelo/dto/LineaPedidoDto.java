package pedidos.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LineaPedidoDto {
	
	private int numeroOrden;
	private int idPedido;
	private long idProducto;
	private int cantidad;
	private double precioUnitario;
	
	
	

}
