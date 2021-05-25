package com.mondrew.microservicios.app.usuarios.services;

import java.util.List;

import com.mondrew.microservicios.commons.estudiantes.models.entity.Estudiante;
import com.mondrew.microservicios.commons.services.CommonService;

public interface EstudianteService extends CommonService<Estudiante> {
	
	public List<Estudiante> findByNombreOrApellido(String termino);
	
}
