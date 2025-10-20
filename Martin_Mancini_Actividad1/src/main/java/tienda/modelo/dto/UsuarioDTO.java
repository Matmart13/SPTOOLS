package tienda.modelo.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDTO {

	private long idUsuario ;
	private String nombre ;
	private String email ;
	private String password;
	private int enabled;
	private String rol;
	private Date fechaRegistro ;
	

	
}
