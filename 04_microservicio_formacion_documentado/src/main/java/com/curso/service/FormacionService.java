package com.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Formacion;

@Service
public interface FormacionService {
	
	//Lista de cursos existentes
	List<Formacion> formacionesExistentes();
	
	//Alta curso
	void nuevaFormacion (Formacion formacion);
}
