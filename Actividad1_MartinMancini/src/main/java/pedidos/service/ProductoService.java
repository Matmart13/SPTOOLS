package pedidos.service;

import java.util.List;

import pedidos.modelo.dto.ProductoDTO;

public interface ProductoService {
		
	public List<ProductoDTO>requestAllProducto();
	public ProductoDTO findByIdProducto(Long id);
	public ProductoDTO createProducto(ProductoDTO producto);
	public ProductoDTO updateProducto(Long id,ProductoDTO producto);
	public void deleteProducto(Long id);
	public List<ProductoDTO> findByCategoryProduct(Integer categoria);
    List<ProductoDTO> findByStockLessThan(int cantidad);

}
