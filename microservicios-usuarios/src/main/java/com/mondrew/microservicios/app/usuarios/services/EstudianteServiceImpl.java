package com.mondrew.microservicios.app.usuarios.services;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mondrew.microservicios.app.usuarios.models.repository.EstudianteRepository;
import com.mondrew.microservicios.commons.estudiantes.models.entity.Estudiante;
import com.mondrew.microservicios.commons.services.CommonServiceImpl;

@Service
public class EstudianteServiceImpl extends CommonServiceImpl<Estudiante, EstudianteRepository> implements EstudianteService  {

	@Override
	@Transactional(readOnly = true)
	public List<Estudiante> findByNombreOrApellido(String termino) {
		return super.repository.findByNombreOrApellido(termino);
	}

}
