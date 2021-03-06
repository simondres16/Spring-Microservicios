package com.mondrew.microservicios.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mondrew.microservicios.commons.services.CommonService;

public class CommonController<E,S extends CommonService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		Optional<E> entity = service.findById(id);
		return entity.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(entity.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

}
