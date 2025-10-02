package apirest.clientes.modelo.service;

import java.util.List;

import apirest.clientes.modelo.javabean.Cliente;

public interface ClienteService {
	
	
	//Operaciones Crud
	List<Cliente> findAll();
	Cliente findById(String cif);
	Cliente insertOne(Cliente cliente);
	Cliente updateOne(Cliente cliente);
	int deleteById(String cif);
	int deleteCliente(Cliente cliente);
	
	
	// consultas propias del Cliente
	List<Cliente> findByFactMayorQue(double facturacion);
	List<Cliente> findByNombreContaining(String cadena);
	List<Cliente> findByPlantillaMayorQue(int plantilla);

}
