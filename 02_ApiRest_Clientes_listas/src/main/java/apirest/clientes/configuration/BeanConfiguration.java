package apirest.clientes.configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import apirest.clientes.modelo.javabean.Cliente;

@Configuration
public class BeanConfiguration {

	@Bean
	List<Cliente> listaClientes(){
		List<Cliente> lista = new ArrayList<>();
		lista.add(new Cliente("1", "UNIRFP", 120000, 234, LocalDate.of(2000,4, 12)));
		lista.add(new Cliente("2", "LIT", 90000, 22, LocalDate.of(2010,4, 12)));
		lista.add(new Cliente("3", "LOL", 150000, 235, LocalDate.of(2009,4, 12)));

		
		return lista;
		
	}
}
