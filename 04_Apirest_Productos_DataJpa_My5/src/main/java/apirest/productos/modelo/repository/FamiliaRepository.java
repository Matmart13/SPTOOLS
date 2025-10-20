package apirest.productos.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import apirest.productos.modelo.entities.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Integer>{

}
