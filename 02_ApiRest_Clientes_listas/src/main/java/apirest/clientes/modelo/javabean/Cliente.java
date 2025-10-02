package apirest.clientes.modelo.javabean;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
	
	private String cif;
	private String nombre;
	private Double facturacionAnual;
	private int plantilla;
	private LocalDate fechaCreacion;
	
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}



	public Cliente(String cif, String nombre, double facturacionAnual,int plantilla, LocalDate fechaCreacion) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.facturacionAnual = facturacionAnual;
		this.plantilla = plantilla;
		this.fechaCreacion = fechaCreacion;
	}



	public String getCif() {
		return cif;
	}



	public void setCif(String cif) {
		this.cif = cif;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Double getFacturacionAnual() {
		return facturacionAnual;
	}



	public void setFacturacionAnual(Double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}



	public int getPlantilla() {
		return plantilla;
	}



	public void setPlantilla(int plantilla) {
		this.plantilla = plantilla;
	}



	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + ", facturacionAnual=" + facturacionAnual + ", plantilla="
				+ plantilla + ", fechaCreacion=" + fechaCreacion + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif);
	}
	
	
	public double ratioFacturacion() {
		return facturacionAnual/plantilla;
	}

}
