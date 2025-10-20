package tienda.modelo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LineaPedidoDTO {
	
	private long numeroOrden;
	private ProductoDTO producto;
	private int cantidad;
	private double precioUnitatio;
	private PedidoDTO pedido;
	

}
