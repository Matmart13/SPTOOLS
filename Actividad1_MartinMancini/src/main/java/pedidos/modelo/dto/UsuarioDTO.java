package pedidos.modelo.dto;

import java.time.LocalDate;

public class UsuarioDTO {
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	 public UsuarioDTO(int idUsuario, String nombre, String email, LocalDate fechaRegistro) {
	        this.idUsuario = idUsuario;
	        this.nombre = nombre;
	        this.email = email;
	        this.fechaRegistro = fechaRegistro;
	    }
	private int idUsuario;
	private String nombre;
	private String email;
	private LocalDate fechaRegistro;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

}
