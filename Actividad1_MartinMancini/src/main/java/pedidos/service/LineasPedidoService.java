package pedidos.service;

import java.util.List;

import pedidos.modelo.dto.ProductoVentaDTO;

public interface LineasPedidoService {
	
	public List<ProductoVentaDTO> obtenerCantidadTotalVendidaPorProducto();
	
}
