package pedidos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import pedidos.modelo.dto.UsuarioDTO;

public interface UsuarioService {
	
    List<UsuarioDTO> getClientsWithOrders();
    List<UsuarioDTO> getClientsRegisteredAfter(LocalDate date);
    List<UsuarioDTO> getClientsRegisteredOn(LocalDate date);
    public Optional<UsuarioDTO> findClienteByEmail(String email);
	
}
