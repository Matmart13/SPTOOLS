package apirest.productos.modelo.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "productos")

public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int id_producto;
	private	String descripcion;
	private	String marca ;
	@Column(name="precio_unitario")
	private	Double precio_unitario ;
	private	int stock ;
	
	@Column(name="fecha_alta")
	@Temporal(TemporalType.DATE)
	private	LocalDate fecha_alta ;
	
	@ManyToOne
	@JoinColumn(name="id_familia")
	private	Familia familia;
	
		
	
	

}
