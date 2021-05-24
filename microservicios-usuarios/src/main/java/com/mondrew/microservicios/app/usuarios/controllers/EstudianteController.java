package com.mondrew.microservicios.app.usuarios.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mondrew.microservicios.app.usuarios.services.EstudianteService;
import com.mondrew.microservicios.commons.controllers.CommonController;
import com.mondrew.microservicios.commons.estudiantes.models.entity.Estudiante;

@RestController
public class EstudianteController extends CommonController<Estudiante, EstudianteService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Estudiante estudianteBody) {
		Optional<Estudiante> estudiante = super.service.findById(id);
		if (estudiante.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Estudiante estudianteBd = estudiante.get();
		estudianteBd.setNombre(estudianteBody.getNombre());
		estudianteBd.setApellido(estudianteBody.getApellido());
		estudianteBd.setEmail(estudianteBody.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(super.service.save(estudianteBd));
	}

}
