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
@Table(name = "Productos")
public class Producto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_producto")
		private Long idProducto;
		private String nombre;
		private double precio;
		private int stock;
		
		@ManyToOne
		@JoinColumn(name="id_categoria",nullable = false)
		private Categoria categoria;
		
		public Producto() {
			// TODO Auto-generated constructor stub
		}
		public Producto(Long _idProduct, String _nombre, double _precio, int _stock, Categoria _categoria) {
			// TODO Auto-generated constructor stub
			setIdProducto(_idProduct);
			setNombre(_nombre);
			setPrecio(_precio);
			setStock(_stock);
			setCategoria(_categoria);
		}
		public long getIdProducto() {
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

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		@Override
		public int hashCode() {
			return Objects.hash(categoria, idProducto, nombre, precio, stock);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof Producto))
				return false;
			Producto other = (Producto) obj;
			return Objects.equals(categoria, other.categoria) && idProducto == other.idProducto
					&& Objects.equals(nombre, other.nombre)
					&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && stock == other.stock;
		}

		@Override
		public String toString() {
			return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", stock="
					+ stock + ", categoria=" + categoria + "]";
		}
		
		
}
