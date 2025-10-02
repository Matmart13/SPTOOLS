package apirest.clientes.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.clientes.modelo.javabean.Cliente;

@Service //@Repository Para que lo encuentre en tiempo de ejecucion
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private List<Cliente> lista;
	
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return this.lista;
	}

	@Override
	public Cliente findById(String cif) {
		// TODO Auto-generated method stub
		
		return lista.stream()
				.filter(c -> c.getCif().equals(cif))
				.findFirst().orElse(null);
	}

	@Override
	public Cliente insertOne(Cliente cliente) {
		// TODO Auto-generated method stub
		if(lista.contains(cliente)) 
			return null;
	
			lista.add(cliente);

		return cliente;
	}

	@Override
	public Cliente updateOne(Cliente cliente) {
		// TODO Auto-generated method stub
		int posicion = lista.indexOf(cliente);
		if(posicion != -1) {
			 lista.set(posicion, cliente);
			 return cliente;
		}
		return null;
	}

	@Override
	public int deleteById(String cif) {
		// TODO Auto-generated method stub
		Cliente cliente = findById(cif);
		return deleteCliente(cliente);
	}

	@Override
	public int deleteCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return lista.remove(cliente) ? 1 : 0; //? Si se cumple 1 y si no 0
	}

	@Override
	public List<Cliente> findByFactMayorQue(double facturacion) {
		// TODO Auto-generated method stub
		return lista.stream()
				.filter(c -> c.getFacturacionAnual() > facturacion )
				.toList();
	}

	@Override
	public List<Cliente> findByNombreContaining(String cadena) {
		// TODO Auto-generated method stub
		return lista.stream()
				.filter(c -> c.getNombre().contains(cadena))
				.toList();
	}

	@Override
	public List<Cliente> findByPlantillaMayorQue(int plantilla) {
		// TODO Auto-generated method stub
		return null;
	}

}
