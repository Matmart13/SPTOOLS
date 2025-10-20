package tienda.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tienda.modelo.dto.CategoriaDTO;
import tienda.modelo.entities.Categoria;
import tienda.modelo.mapper.CategoriaMapper;
import tienda.modelo.repository.CategoriaRepository;

@RestController
public class CategoriaRestController {
	private CategoriaRepository categoria;
	
	@GetMapping("/categorias")
	public List<Categoria> all(){
		return categoria.findAllCategoria();
	}
	@GetMapping("/categorias/{id}")
	public CategoriaDTO CategoriaDTrequestbyID(@PathVariable Long id){
		return categoria.findByCategoria_IdCategoria(id);
	}
	@PostMapping("/categorias")
	public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		   Categoria categoria1 = CategoriaMapper.dtoToEntity(categoriaDTO);
		    Categoria saved = categoria.save(categoria1);
        return CategoriaMapper.entityToDto(saved);
	}
    

	@PutMapping("/categorias/{id}")
	public CategoriaDTO updateProducto(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
	     return categoria.modifyCategoria(id, categoriaDTO);
	 }
	
    @DeleteMapping("/categorias/{id}")
    public void deleteProducto(@PathVariable Long id) {
        categoria.deleteCategoria(id);
    }

	
	
	
}
