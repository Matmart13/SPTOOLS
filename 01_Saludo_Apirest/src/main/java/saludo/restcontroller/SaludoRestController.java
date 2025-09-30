package saludo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoRestController {
	
	@GetMapping("/saludo")
	public String saludar() {
		return "Hola me llamo Martin";
	}
	
	@GetMapping("/saludo2")
	public String saludar2() {
		return "Hola internauta";
	}
	
	//Parametros de entrada Ej= http://localhost:8083/saludoPorParam?nombre=Martin&profesion=cantante
	@GetMapping("/saludoPorParam")
	public String saludarParam(@RequestParam String nombre, @RequestParam String profesion) {
		return "Hola te llamas "+ nombre + " y eres " + profesion;
	}
	
	
	//Variables de entrada Ej = 
	@GetMapping("/saludoPorVar/{nombre}/{profesion}")
	public String saludarVar(@PathVariable String nombre, @PathVariable String profesion) {
			return "Hola te llamas "+ nombre + " y eres " + profesion;
	}

}
