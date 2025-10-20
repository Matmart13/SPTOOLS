package pedidos.restcontroller;

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

import pedidos.modelo.dto.CategoriaDTO;
import pedidos.service.CategoriaService;
@RestController
public class CategoriaRestController {
	
    @Autowired
    private CategoriaService categoriaService;
	
	@GetMapping("/categorias") //Devuelve todas las categorias
	public List<CategoriaDTO> listaCategorias(){
		return categoriaService.requestAllCategoria();
	}
	@GetMapping("/categorias{id}") //Devuelve todas las categorias
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Integer id) {
        CategoriaDTO categoriaDTO = categoriaService.findByIdCategoria(id);
        if (categoriaDTO == null) {
            return ResponseEntity.notFound().build(); // HTTP 404
        }
        return ResponseEntity.ok(categoriaDTO);
    }
    @PostMapping("/categorias")
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO nuevaCategoria = categoriaService.createCategoria(categoriaDTO);
        return ResponseEntity.ok(nuevaCategoria); // HTTP 200 OK, puedes usar 201 Created si quieres
    }
    @PutMapping("/categorias{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Integer id,
                                                         @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO actualizado = categoriaService.updateCategoria(id, categoriaDTO);
        if (actualizado == null) {
            return ResponseEntity.notFound().build(); // HTTP 404 si no existe
        }
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/categorias{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        CategoriaDTO categoriaExistente = categoriaService.findByIdCategoria(id);
        if (categoriaExistente == null) {
            return ResponseEntity.notFound().build(); // HTTP 404 si no existe
        }
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }

}
