package com.mondrew.microservicios.app.cursos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mondrew.microservicios.app.cursos.models.entity.Curso;
import com.mondrew.microservicios.app.cursos.services.CursoService;
import com.mondrew.microservicios.commons.controllers.CommonController;
import com.mondrew.microservicios.commons.estudiantes.models.entity.Estudiante;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Curso CursoBody) {
		Optional<Curso> Curso = super.service.findById(id);
		if (Curso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoBd = Curso.get();
		cursoBd.setNombre(CursoBody.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(super.service.save(cursoBd));
	}

	@PutMapping("/{id}/asignar-estudiantes")
	public ResponseEntity<?> asignarEstudiantes(@RequestBody List<Estudiante> estudiantes, @PathVariable Long id) {
		Optional<Curso> Curso = super.service.findById(id);
		if (Curso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoBd = Curso.get();

		estudiantes.forEach(estudiante -> cursoBd.addEstudiantes(estudiante));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(super.service.save(cursoBd));
	}
	
	@PutMapping("/{id}/eliminar-estudiante")
	public ResponseEntity<?> eliminarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id) {
		Optional<Curso> Curso = super.service.findById(id);
		if (Curso.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Curso cursoBd = Curso.get();

		cursoBd.removeEstudiantes(estudiante);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(super.service.save(cursoBd));
	}
}
