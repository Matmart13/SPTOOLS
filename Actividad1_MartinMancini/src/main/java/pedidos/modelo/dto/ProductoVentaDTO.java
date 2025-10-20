package pedidos.modelo.dto;

import java.util.Objects;

public class ProductoVentaDTO {
	
    private Long idProducto;
    private String nombre;
    private long  cantidadTotalVendida;

    public ProductoVentaDTO(Long idProducto, String nombre, long  cantidadTotalVendida) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidadTotalVendida = cantidadTotalVendida;
    }

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

	public long getCantidadTotalVendida() {
		return cantidadTotalVendida;
	}

	public void setCantidadTotalVendida(long cantidadTotalVendida) {
		this.cantidadTotalVendida = cantidadTotalVendida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadTotalVendida, idProducto, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProductoVentaDTO))
			return false;
		ProductoVentaDTO other = (ProductoVentaDTO) obj;
		return cantidadTotalVendida == other.cantidadTotalVendida && idProducto == other.idProducto
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "ProductoVentaDTO [idProducto=" + idProducto + ", nombre=" + nombre + ", cantidadTotalVendida="
				+ cantidadTotalVendida + "]";
	}
    
}
