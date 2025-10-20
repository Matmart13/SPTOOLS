package tienda.modelo.entities;


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
@Table(name="LineaPedido")
public class LineaPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numeroOrden;
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	private int cantidad;
	private double precioUnitatio;
	@ManyToOne
    @JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	
}
