package pedidos.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pedidos.modelo.dto.ProductoDTO;
import pedidos.service.ProductoService;

@RestController
public class ProductoRestController {
	
	  @Autowired
	   private ProductoService productoService;
	  
	  @GetMapping("/productos") //Devuelve todos los productos
		public List<ProductoDTO> listaProductos(){
			return productoService.requestAllProducto();
		}

		@GetMapping("/productos/{id}") //Devuelve todas las categorias
	    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Long id) {
			ProductoDTO productoDTO = productoService.findByIdProducto(id);
	        if (productoDTO == null) {
	            return ResponseEntity.notFound().build(); // HTTP 404
	        }
	        return ResponseEntity.ok(productoDTO);
	    }
		@PostMapping("/productos")
	    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
			ProductoDTO nuevoProducto = productoService.createProducto(productoDTO);
		    URI location = ServletUriComponentsBuilder
		            .fromCurrentRequest()
		            .path("/{id}")
		            .buildAndExpand(nuevoProducto.getIdProducto())
		            .toUri();
	        return ResponseEntity.created(location).body(nuevoProducto); // HTTP 200 OK, puedes usar 201 Created si quieres
	    }
		 @PutMapping("/productos/{id}")
		    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id,
		                                                      @RequestBody ProductoDTO categoriaDTO) {
			 ProductoDTO actualizado = productoService.updateProducto(id, categoriaDTO);
		        if (actualizado == null) {
		            return ResponseEntity.notFound().build(); // HTTP 404 si no existe
		        }
		        return ResponseEntity.ok(actualizado);
		    }
		 @DeleteMapping("/productos/{id}")
		    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
			 ProductoDTO productoExistente = productoService.findByIdProducto(id);
		        if (productoExistente == null) {
		            return ResponseEntity.notFound().build(); // HTTP 404 si no existe
		        }
		        productoService.deleteProducto(id);
		        return ResponseEntity.noContent().build(); // HTTP 204 No Content
		    }
		 @GetMapping("/productos/por-categoria/{id}")
		 public ResponseEntity<List<ProductoDTO>> getProductosPorCategoria(@PathVariable Integer id) {
		     List<ProductoDTO> productos = productoService.findByCategoryProduct(id);
		     return ResponseEntity.ok(productos);
		 }
		 @GetMapping("productos/stock-menor/{stock}")
		 public ResponseEntity<List<ProductoDTO>> getProductosConStockMenor(@PathVariable int cantidad) {
		     List<ProductoDTO> productos = productoService.findByStockLessThan(cantidad);
		     if (productos.isEmpty()) {
		         return ResponseEntity.noContent().build(); // HTTP 204 si no hay resultados
		     }
		     return ResponseEntity.ok(productos); // HTTP 200 con la lista de DTOs
		 }

}
