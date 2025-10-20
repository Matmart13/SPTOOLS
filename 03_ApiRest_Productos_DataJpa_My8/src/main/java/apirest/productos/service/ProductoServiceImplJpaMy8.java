package apirest.productos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.productos.modelo.entities.Producto;
import apirest.productos.modelo.respository.ProductoRepository;

@Service
public class ProductoServiceImplJpaMy8 implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	@Override
	public Producto buscarUno(int idProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idProducto).orElse(null);
	}

}
