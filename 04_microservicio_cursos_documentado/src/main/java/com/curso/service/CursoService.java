package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursoService{
	
	//Lista de cursos
	List<Curso> listarCursos();
	
	//Alta de curso
	List<Curso> altaCurso(Curso curso);
	
	//Eliminacion de un curso
	List<Curso> eliminarCurso(String codCurso);
	
	//Actualización duración
	void actualizarDuracionCurso(String codCurso, Double duracion);
	
	//Buscar curso
	Curso buscarCurso(String codCurso);
	
	//Cursos por precio
	List<Curso> cursosPorPrecios(Double precioMin, Double precioMax);
}
