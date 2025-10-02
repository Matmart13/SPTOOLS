package apirest.clientes.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import apirest.clientes.modelo.javabean.Cliente;
import apirest.clientes.modelo.service.ClienteService;
@RestController
public class ClienteRestController {
		/*@Autowired
		private List<Cliente> lista; //JAMAS SE HACE ESTO controlador independiente de la fuente de datos
		 */
	
		@Autowired //Importante
		private ClienteService clienteService;
	
		@GetMapping("/clientes/todos")
		public List<Cliente> todos(){
			return clienteService.findAll();
		}
		
		@PostMapping("/clientes/alta")
		public Cliente altaCliente(@RequestBody Cliente cliente) {
			return clienteService.insertOne(cliente);
		}
		@GetMapping("/clientes/porFactMayor/{facturacion}")
		public List<Cliente> factMayor(@PathVariable double facturacion){
			return clienteService.findByFactMayorQue(facturacion);
		}
		@GetMapping("/clientes/nombre/{cadena}")
		public List<Cliente> cadena(@PathVariable String cadena){
			return clienteService.findByNombreContaining(cadena);
		}
	
}
