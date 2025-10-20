package pedidos.modelo.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "LINEAS_PEDIDO")
public class LineasPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_orden")
	private long numeroOrden;
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	private int cantidad;
	@Column(name = "precio_unitario")
	private double precioUnitario;
	public long getNumeroOrden() {
		return numeroOrden;
	}
	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, numeroOrden, pedido, precioUnitario, producto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LineasPedido))
			return false;
		LineasPedido other = (LineasPedido) obj;
		return cantidad == other.cantidad && numeroOrden == other.numeroOrden && Objects.equals(pedido, other.pedido)
				&& Double.doubleToLongBits(precioUnitario) == Double.doubleToLongBits(other.precioUnitario)
				&& Objects.equals(producto, other.producto);
	}
	@Override
	public String toString() {
		return "LineasPedido [numeroOrden=" + numeroOrden + ", pedido=" + pedido + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + "]";
	}
	
	

}
