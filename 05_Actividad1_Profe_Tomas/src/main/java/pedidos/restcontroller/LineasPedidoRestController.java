package pedidos.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.dto.LineaPedidoDto;
import pedidos.modelo.entities.LineasPedido;
import pedidos.modelo.repository.LineasPedidoRepository;

@RestController
@RequestMapping("/lp")
public class LineasPedidoRestController {
	
	@Autowired
	private LineasPedidoRepository lpRepo;
	
	@GetMapping("/")
	List<LineaPedidoDto> todas(){
//		List<LineasPedido> lista = lpRepo.findAll();
		
		List<LineaPedidoDto> aux = new ArrayList<>();
		for (LineasPedido linea: lpRepo.findAll()) {
			LineaPedidoDto lineaP = new LineaPedidoDto();
			lineaP.setCantidad(linea.getCantidad());
			lineaP.setIdPedido(linea.getPedido().getIdPedido());
			lineaP.setIdProducto(linea.getProducto().getIdProducto());
			lineaP.setNumeroOrden(linea.getNumeroOrden());
			lineaP.setPrecioUnitario(linea.getPrecioUnitario());
			aux.add(lineaP);
			
			
		}
		
		return aux;
		
	}

}
