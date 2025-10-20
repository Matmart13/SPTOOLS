package tienda.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.modelo.dto.CategoriaDTO;
import tienda.modelo.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllCategoria();
	public CategoriaDTO findByCategoria_IdCategoria(Long id);
	public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO );
	public CategoriaDTO modifyCategoria(Long categoria, CategoriaDTO categoriaDTO);
	public CategoriaDTO  deleteCategoria(Long id);
	
	
}
