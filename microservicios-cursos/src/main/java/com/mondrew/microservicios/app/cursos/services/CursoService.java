package com.mondrew.microservicios.app.cursos.services;

import com.mondrew.microservicios.app.cursos.models.entity.Curso;
import com.mondrew.microservicios.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {
	
	public Curso findCursoByEstudianteId(Long id);
	
}
