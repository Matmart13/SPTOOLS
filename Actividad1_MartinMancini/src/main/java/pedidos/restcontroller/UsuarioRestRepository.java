package pedidos.restcontroller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pedidos.modelo.dto.UsuarioDTO;
import pedidos.service.UsuarioService;

@RestController
public class UsuarioRestRepository {
	  @Autowired
	   private UsuarioService usuarioService;
	  @GetMapping("/clientes/por-email/{texto}") //Devuelve todos los productos
			public ResponseEntity<UsuarioDTO>  listOfClientsByEmail(@PathVariable("texto") String email){
	        Optional<UsuarioDTO> clienteOpt = usuarioService.findClienteByEmail(email);

	        if (clienteOpt.isPresent()) {
	            return ResponseEntity.ok(clienteOpt.get()); // HTTP 200 OK
	        } else {
	            return ResponseEntity.notFound().build(); // HTTP 400 Bad Request
	            // o ResponseEntity.notFound().build(); // HTTP 404 Not Found si prefieres
	        }
	    }
	  @GetMapping("/clientes/registro/{fecha}")
	    public List<UsuarioDTO> getClientesByExactRegistrationDate(@PathVariable LocalDate fecha) {
	        return usuarioService.getClientsRegisteredOn(fecha);
	    }
	  @GetMapping("/clientes/despues-fecha/{fecha}")
	    public List<UsuarioDTO> getClientesAfterThatDate(@PathVariable LocalDate fecha) {
	        return usuarioService.getClientsRegisteredAfter(fecha);
	    }
	  @GetMapping("/clientes/algun-pedido")
	  public List<UsuarioDTO> getClientesWithPedido() {
	        return usuarioService.getClientsWithOrders();
	    }
	  
}
