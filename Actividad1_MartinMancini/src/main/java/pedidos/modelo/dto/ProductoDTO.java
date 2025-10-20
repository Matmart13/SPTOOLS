package pedidos.modelo.dto;

import java.util.Objects;



public class ProductoDTO {
	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}
	public ProductoDTO(Long _idProduct, String _nombre, double _precio, int _stock, int _categoria) {
		// TODO Auto-generated constructor stub
		setIdProducto(_idProduct);
		setNombre(_nombre);
		setPrecio(_precio);
		setStock(_stock);
		setCategoria(_categoria);
	}
	public ProductoDTO( String _nombre, double _precio, int _stock, int _categoria) {
		// TODO Auto-generated constructor stub
		
		setNombre(_nombre);
		setPrecio(_precio);
		setStock(_stock);
		setCategoria(_categoria);
	}
	private Long idProducto;
	private String nombre;
	private double precio;
	private int stock;
	private int idCategoria;
	
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoria() {
		return idCategoria;
	}
	public void setCategoria(int categoria) {
		this.idCategoria = categoria;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCategoria, idProducto, nombre, precio, stock);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProductoDTO))
			return false;
		ProductoDTO other = (ProductoDTO) obj;
		return Objects.equals(idCategoria, other.idCategoria) && idProducto == other.idProducto
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock;
	}
	@Override
	public String toString() {
		return "ProductoDTO [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", stock="
				+ stock + ", iDcategoria=" + idCategoria + "]";
	}
	
}
