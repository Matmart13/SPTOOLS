package pedidos.modelo.dto;

import java.util.Objects;

public class CategoriaDTO {
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
	public CategoriaDTO(int idCategoria2, String nombre2, String descripcion2) {
		// TODO Auto-generated constructor stub
		setIdCategoria(idCategoria2);
		setNombre(nombre2);
		setDescripcion(descripcion2);
	}
	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, idCategoria, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CategoriaDTO))
			return false;
		CategoriaDTO other = (CategoriaDTO) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(idCategoria, other.idCategoria)
				&& Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return "CategoriaDTO [idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
