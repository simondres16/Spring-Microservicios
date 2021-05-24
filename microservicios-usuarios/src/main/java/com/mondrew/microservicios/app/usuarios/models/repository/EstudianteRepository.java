package com.mondrew.microservicios.app.usuarios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.mondrew.microservicios.commons.estudiantes.models.entity.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {

	
}
