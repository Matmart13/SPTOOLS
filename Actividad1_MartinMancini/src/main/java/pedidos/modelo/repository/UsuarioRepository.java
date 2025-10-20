package pedidos.modelo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pedidos.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByEmailAndRol(String email, String rol);
	List<Usuario> findByFechaRegistroAfterAndRol(LocalDate fecha, String rol);
    List<Usuario> findByFechaRegistroAndRol(LocalDate fechaRegistro, String rol);
    @Query("SELECT DISTINCT u FROM Usuario u JOIN Pedido p ON p.usuario = u WHERE u.rol = 'CLIENTE'")
    List<Usuario> findClientsWithOrders();
    }
