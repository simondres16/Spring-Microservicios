package com.mondrew.microservicios.app.usuarios.services;
import org.springframework.stereotype.Service;

import com.mondrew.microservicios.app.usuarios.models.repository.EstudianteRepository;
import com.mondrew.microservicios.commons.estudiantes.models.entity.Estudiante;
import com.mondrew.microservicios.commons.services.CommonServiceImpl;

@Service
public class EstudianteServiceImpl extends CommonServiceImpl<Estudiante, EstudianteRepository> implements EstudianteService  {


}
