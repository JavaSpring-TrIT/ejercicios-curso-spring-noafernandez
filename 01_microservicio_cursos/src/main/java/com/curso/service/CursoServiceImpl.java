package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursoDao;
import com.curso.model.Curso;

@Service
public class CursoServiceImpl implements CursoService{
	@Autowired
	CursoDao cursoDao;
	
	//Lista de cursos
	@Override
	public List<Curso> listarCursos(){
		return cursoDao.findAll();
	}
	
	//Alta de curso
	@Override
	public List<Curso> altaCurso(Curso curso){
		cursoDao.save(curso);
		return cursoDao.findAll();
		
	}
	
	//Eliminacion de un curso
	@Override
	public List<Curso> eliminarCurso(String codCurso){
		cursoDao.deleteById(codCurso);
		return cursoDao.findAll();
	}
	
	//Actualización duración
	@Override
	public void actualizarDuracionCurso(Double duracion) {
		Curso c = new Curso ();
		c.setDuracion(duracion);
		cursoDao.save(c);
		
	}
	
	//Buscar curso
	@Override
	public Curso buscarCurso(String codCurso) {
		return cursoDao.findById(codCurso).orElse(null);
	}

	//Cursos por precio
	@Override
	public List<Curso> cursosPorPrecios(Double precioMin, Double precioMax){
		return cursoDao.getCursosBetweenPrecios(precioMin, precioMax);
	}
	
}
