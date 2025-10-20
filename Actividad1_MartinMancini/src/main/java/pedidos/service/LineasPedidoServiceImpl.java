package pedidos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pedidos.modelo.dto.ProductoVentaDTO;
import pedidos.modelo.repository.LineasPedidoRepository;

@Service
public class LineasPedidoServiceImpl implements LineasPedidoService{
	LineasPedidoRepository lineaPedidoRepository;

    public LineasPedidoServiceImpl(LineasPedidoRepository lineasPedidoRepository) {
        this.lineaPedidoRepository = lineasPedidoRepository;
    }
	@Override
	public List<ProductoVentaDTO> obtenerCantidadTotalVendidaPorProducto() {
	    return lineaPedidoRepository.findTotalCantidadVendidaPorProducto();
	}


}
