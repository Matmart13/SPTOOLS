package pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.dto.CategoriaDTO;
import pedidos.modelo.entities.Categoria;
import pedidos.modelo.map.CategoriaMapping;
import pedidos.modelo.repository.CategoriaRepository;
@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
    private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaMapping categoriaMapper;

    @Override
    public List<CategoriaDTO> requestAllCategoria() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categoriaMapper.toDTOList(categorias);
    }


	@Override
	public CategoriaDTO  findByIdCategoria(Integer id) {
        Categoria categoria = categoriaRepository.findById(id).orElse(null);
        return categoriaMapper.toDTO(categoria);
	}

	@Override
	public CategoriaDTO createCategoria(CategoriaDTO _categoria) {
	    Categoria categoria = categoriaMapper.toEntity(_categoria);
	    // Se crea null porque al ser auto_increment se añade solo
	    categoria.setIdCategoria(null);
	    Categoria saved = categoriaRepository.save(categoria);
	    return categoriaMapper.toDTO(saved);
	}

	@Override
	public CategoriaDTO updateCategoria(Integer id,CategoriaDTO categoria) {
	    // Buscar la categoría existente
	    Categoria categoriaExistente = categoriaRepository.findById(id).orElse(null);
	    if (categoriaExistente == null)
	    	return null;

	    // Actualizar campos
	    categoriaExistente.setNombre(categoria.getNombre());
	    categoriaExistente.setDescripcion(categoria.getDescripcion());

	    // Guardar cambios
	    Categoria actualizado = categoriaRepository.save(categoriaExistente);

	    // Convertir a DTO y devolver
	    return categoriaMapper.toDTO(actualizado);

	}

	@Override
	public void deleteCategoria(Integer id) {
		// TODO Auto-generated method stub
	    if (!categoriaRepository.existsById(id)) {
	        throw new RuntimeException("Producto con ID " + id + " no existe");
	    }
	    categoriaRepository.deleteById(id);

	}


}
