package tienda.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tienda.modelo.dto.ProductoDTO;
import tienda.modelo.entities.Producto;
import tienda.modelo.repository.ProductosRepository;

public class ProductosRestController {
    
	private ProductosRepository producto;
	
	@GetMapping("/productos")
	public List<Producto> all(){
		return producto.findAllProducto();
	}
	@GetMapping("/productos/{id}")
	public List<Producto> requestbyID(@PathVariable Long id){
		return producto.findByProducto_IdProducto(id);
	}
	@PostMapping("/productos")
	public ProductoDTO createCategoria(@RequestBody ProductoDTO productoDTO) {
        return producto.createProducto(productoDTO);
    }

	@PutMapping("/productos/{id}")
	public ProductoDTO updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
	     return producto.modifyProducto(id, productoDTO);
	 }
	
    @DeleteMapping("/productos/{id}")
    public void deleteProducto(@PathVariable Long id) {
    	producto.deleteProducto(id);
    }

	
	

}
