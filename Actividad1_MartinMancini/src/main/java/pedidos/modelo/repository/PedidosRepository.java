package pedidos.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pedidos.modelo.entities.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
	List<Pedido> findAll();
}
