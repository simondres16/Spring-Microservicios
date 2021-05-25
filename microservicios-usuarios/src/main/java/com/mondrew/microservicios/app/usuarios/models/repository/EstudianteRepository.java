package com.mondrew.microservicios.app.usuarios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mondrew.microservicios.commons.estudiantes.models.entity.Estudiante;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {

	@Query("select e from Estudiante e where e.nombre like %?1% or e.apellido like %?1%")
	public List<Estudiante> findByNombreOrApellido(String termino);
	
}
