package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@CrossOrigin("*")
@RestController
public class CursosController {
	
	@Autowired
	private CursoService cursoService;
	

	@ApiOperation(value = "Listado de cursos existentes")
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listarCursos() {
		return cursoService.listarCursos();
	}
	
	
	@ApiOperation(value = "Da de alta un nuevo curso")
	@PostMapping(value="curso",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> alta(@ApiParam(value= "JSON con los campos del curso")@RequestBody Curso curso) {
		return cursoService.altaCurso(curso);
	}
	
	@ApiOperation(value = "Elimina un curso existente")
	@DeleteMapping(value="curso/{codCurso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@ApiParam(value= "Código del curso")@PathVariable("codCurso") String codCurso){
		return cursoService.eliminarCurso(codCurso);
	}
	
	@ApiOperation(value = "Actualiza la duración de un curso existente")
	@PutMapping(value="curso/codCurso/{duracion}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar (@ApiParam(value= "Código del curso")@PathVariable("codCurso") String codCurso,
			@ApiParam(value= "Duración del curso (en horas)")@PathVariable("duracion") Double duracion) {
		cursoService.actualizarDuracionCurso(codCurso, duracion);
	} 
	
	@ApiOperation(value = "Busca un curso por su código")
	@GetMapping(value="curso/{codCurso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@ApiParam(value= "Código del curso")@PathVariable("codCurso") String codCurso) {
		return cursoService.buscarCurso(codCurso);
	}
	
	@ApiOperation(value = "Listado de cursos entre un rango de precios")
	@GetMapping(value="cursos/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursosEntrePrecios(@ApiParam(value= "Valor de precio mínimo") @PathVariable("precioMin") Double precioMin, 
			@ApiParam(value= "Valor de precio máximo") @PathVariable("precioMax") Double precioMax) {
		return cursoService.cursosPorPrecios(precioMin, precioMax);
	}
}

