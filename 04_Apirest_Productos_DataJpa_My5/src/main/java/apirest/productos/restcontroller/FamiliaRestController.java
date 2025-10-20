package apirest.productos.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import apirest.productos.modelo.entities.Familia;
import apirest.productos.service.FamiliaService;

@RestController
public class FamiliaRestController {
	
	@Autowired
	private FamiliaService familiaService;
	
	@GetMapping("/{idFamilia}")
	public Familia uno(@PathVariable int idFamilia) {
		return familiaService.buscarUna(idFamilia);
	}

}
