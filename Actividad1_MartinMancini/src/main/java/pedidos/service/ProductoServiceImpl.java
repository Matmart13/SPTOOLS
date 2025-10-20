package pedidos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedidos.modelo.dto.ProductoDTO;
import pedidos.modelo.entities.Categoria;
import pedidos.modelo.entities.Producto;
import pedidos.modelo.map.ProductoMapping;
import pedidos.modelo.repository.CategoriaRepository;
import pedidos.modelo.repository.ProductoRepository;
@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
    private CategoriaRepository categoriaRepository;
	@Autowired
    private ProductoRepository productoRepository;

	@Autowired
	private ProductoMapping productoMapper;

	@Override
	public List<ProductoDTO> requestAllProducto() {
		List<Producto> producto = productoRepository.findAll();
		return productoMapper.toDTOList(producto);
	}

	@Override
	public ProductoDTO findByIdProducto(Long id) {
		Producto producto = productoRepository.findById(id.intValue()).orElse(null);
		return productoMapper.toDTO(producto);
	}

	@Override
	public ProductoDTO createProducto(ProductoDTO _producto) {
		  // Buscamos la categoría por id
	    Categoria categoria = categoriaRepository.findById(_producto.getCategoria())
	            .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

	    // Convertimos DTO a entidad usando la categoría
	    Producto producto = productoMapper.toEntity(_producto, categoria);

	    // Guardamos en la base de datos
	    Producto saved = productoRepository.save(producto);

	    // Devolvemos el DTO
	    return productoMapper.toDTO(saved);
	}

	@Override
	public ProductoDTO updateProducto(Long id,ProductoDTO producto) {
		// TODO Auto-generated method stub
		Producto productoExistente = productoRepository.findById(id.intValue()).orElse(null);
		if(productoExistente == null)
			return null;
		productoExistente.setIdProducto(producto.getIdProducto());
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setPrecio(producto.getPrecio());
		productoExistente.setStock(producto.getStock());
		Categoria cat = categoriaRepository.findById(producto.getCategoria())
			    .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
	    // Guardar cambios
	    Producto actualizado = productoRepository.save(productoExistente);

	    // Devolver DTO
	    return productoMapper.toDTO(actualizado);

	}

	@Override
	public void deleteProducto(Long id) {
		// TODO Auto-generated method stub
	    if (!productoRepository.existsById(id.intValue())) {
	        throw new RuntimeException("Producto con ID " + id + " no existe");
	    }
	    productoRepository.deleteById(id.intValue());

	}

	@Override
	public List<ProductoDTO> findByCategoryProduct(Integer categoria) {
	    List<Producto> productos = productoRepository.findByCategoriaIdCategoria(categoria);
	    return productos.stream()
	            .map(productoMapper::toDTO)
	            .collect(Collectors.toList());
	}


	@Override
	public List<ProductoDTO> findByStockLessThan(int cantidad) {
		// TODO Auto-generated method stub
		 List<Producto> productos = productoRepository.findByStockLessThan(cantidad);
		    return productoMapper.toDTOList(productos); // Mapea la lista de entidades a DTOs
	}
}


