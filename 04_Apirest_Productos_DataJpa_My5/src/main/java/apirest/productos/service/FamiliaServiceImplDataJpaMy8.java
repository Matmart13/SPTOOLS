package apirest.productos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.productos.modelo.entities.Familia;
import apirest.productos.modelo.repository.FamiliaRepository;

@Service
public class FamiliaServiceImplDataJpaMy8 implements FamiliaService{
	
	@Autowired
	private FamiliaRepository familiaRepository;

	@Override
	public Familia buscarUna(int idFamilia) {
		// TODO Auto-generated method stub
		return familiaRepository.findById(idFamilia).orElse(null);
	}

}
