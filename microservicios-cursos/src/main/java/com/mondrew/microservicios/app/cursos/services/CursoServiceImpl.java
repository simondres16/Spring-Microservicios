package com.mondrew.microservicios.app.cursos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mondrew.microservicios.app.cursos.models.entity.Curso;
import com.mondrew.microservicios.app.cursos.models.repository.CursoRepository;
import com.mondrew.microservicios.commons.services.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByEstudianteId(Long id) {		
		return super.repository.findCursoByEstudianteId(id);
	}

}
