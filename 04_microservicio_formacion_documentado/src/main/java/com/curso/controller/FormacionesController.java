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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class FormacionesController {
	@Autowired
	FormacionService formacionService;

	@ApiOperation(value = "Listado de las formaciones existentes")
	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> listaFormaciones(){
		return formacionService.formacionesExistentes();
		
	}

	@ApiOperation(value = "Da de alta una nueva formacion")
	@GetMapping (value="formacion/{curso}/{asignaturas}/{precio}")
	public void altaFormacion(@ApiParam(value= "Nombre de la formacion") @PathVariable("curso") String curso, 
			@ApiParam(value= "Número de asignaturas") @PathVariable("asignaturas") int asignaturas, 
			@ApiParam(value= "Precio") @PathVariable("precio") double precio){
		Formacion f = new Formacion (curso, asignaturas, precio);
		formacionService.nuevaFormacion(f);
	}

}
