package pedidos.service;

import java.util.List;

import pedidos.modelo.dto.CategoriaDTO;

public interface CategoriaService  {
		
	public List<CategoriaDTO>requestAllCategoria();
	public CategoriaDTO findByIdCategoria(Integer id);
	public CategoriaDTO createCategoria(CategoriaDTO categoria);
	public CategoriaDTO updateCategoria(Integer id, CategoriaDTO categoria);
	public void deleteCategoria(Integer id);
	

}
