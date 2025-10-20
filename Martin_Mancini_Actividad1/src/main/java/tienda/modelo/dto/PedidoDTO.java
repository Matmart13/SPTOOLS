package tienda.modelo.dto;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PedidoDTO {

	private long idPedido;
	private UsuarioDTO cliente;
	private Date fecha ;
	private LineaPedidoDTO lineas ;
	
	
}
