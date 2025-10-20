package pedidos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedidos.modelo.dto.UsuarioDTO;
import pedidos.modelo.entities.Pedido;
import pedidos.modelo.entities.Usuario;
import pedidos.modelo.map.UsuarioMapping;
import pedidos.modelo.repository.UsuarioRepository;
import pedidos.modelo.repository.PedidosRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService{
	 	@Autowired
	    private UsuarioRepository usuarioRepository;

	    @Autowired
	    private UsuarioMapping usuarioMapper;
	    @Autowired
	    private PedidosRepository pedidoRepository;

	@Override
	public List<UsuarioDTO> getClientsWithOrders() {
	    List<Usuario> clientes = usuarioRepository.findClientsWithOrders();
	    return usuarioMapper.toDTOList(clientes);

	}
	
	@Override
	public List<UsuarioDTO> getClientsRegisteredAfter(LocalDate date) {
	    List<Usuario> clientes = usuarioRepository.findByFechaRegistroAfterAndRol(date, "CLIENTE");
	    return usuarioMapper.toDTOList(clientes);
	}

	@Override
	public List<UsuarioDTO> getClientsRegisteredOn(LocalDate date) {
        List<Usuario> clientes = usuarioRepository.findByFechaRegistroAndRol(date, "CLIENTE");
        return usuarioMapper.toDTOList(clientes);

	}
	public Optional<UsuarioDTO> findClienteByEmail(String email) {
	    return usuarioRepository.findByEmailAndRol(email, "CLIENTE")
	            .map(usuarioMapper::toDTO); // Devuelve Optional<UsuarioDTO>
	}
	
}