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


@CrossOrigin("*")
@RestController
public class CursosController {
	
	@Autowired
	private CursoService cursoService;
	

	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listarCursos() {
		return cursoService.listarCursos();
	}
	
	
	@PostMapping(value="curso",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> alta(@RequestBody Curso curso) {
		return cursoService.altaCurso(curso);
	}
	
	@DeleteMapping(value="curso/{codCurso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@PathVariable("codCurso") String codCurso){
		return cursoService.eliminarCurso(codCurso);
	}
	
	
	@PutMapping(value="curso/{duracion}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar (@PathVariable("duracion") Double duracion) {
		cursoService.actualizarDuracionCurso(duracion);
	} 
	
	@GetMapping(value="curso/{codCurso}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable("codCurso") String codCurso) {
		return cursoService.buscarCurso(codCurso);
	}
	
	@GetMapping(value="cursos/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursosEntrePrecios(@PathVariable("precioMin") Double precioMin, @PathVariable("precioMax") Double precioMax) {
		return cursoService.cursosPorPrecios(precioMin, precioMax);
	}
}

