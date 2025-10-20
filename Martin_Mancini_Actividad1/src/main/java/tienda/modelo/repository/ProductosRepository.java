package tienda.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.modelo.dto.ProductoDTO;
import tienda.modelo.entities.Categoria;
import tienda.modelo.entities.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {

	public List<Producto> findAllProducto();
	public List<Producto> findByProducto_IdProducto(Long ategoria);
	public ProductoDTO createProducto(ProductoDTO productoDTO);
	public ProductoDTO modifyProducto(Long categoria,ProductoDTO productoDTO);
	public ProductoDTO deleteProducto(Long categoria);
	
	
}
