package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

@RestController
public class FormacionesController {
	@Autowired
	FormacionService formacionService;

	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> listaFormaciones(){
		return formacionService.formacionesExistentes();
		
	}

	@GetMapping (value="formacion/{curso}/{asignaturas}/{precio}")
	public void altaFormacion(@PathVariable("curso") String curso, 
			@PathVariable("asignaturas") int asignaturas, 
			@PathVariable("precio") double precio){
		Formacion f = new Formacion (curso, asignaturas, precio);
		formacionService.nuevaFormacion(f);
	}

}
