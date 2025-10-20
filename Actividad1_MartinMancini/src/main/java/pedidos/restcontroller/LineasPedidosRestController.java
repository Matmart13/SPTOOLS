package pedidos.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.dto.ProductoVentaDTO;
import pedidos.service.LineasPedidoService;
@RestController
@RequestMapping("/lineapedido")
public class LineasPedidosRestController {
	@Autowired
	LineasPedidoService lineaPedidoService;
	@GetMapping("/venta-productos")
	public ResponseEntity<List<ProductoVentaDTO>> getCantidadTotalVendidaPorProducto() {
	    List<ProductoVentaDTO> ventas = lineaPedidoService.obtenerCantidadTotalVendidaPorProducto();
	    if (ventas.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(ventas);
	}


}
