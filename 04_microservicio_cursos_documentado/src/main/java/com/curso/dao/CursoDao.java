package com.curso.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Curso;

public interface CursoDao extends JpaRepository<Curso, String>{
	
	@Query("SELECT c FROM Curso c WHERE precio BETWEEN :precioMin AND :precioMax")
	List<Curso> getCursosBetweenPrecios(@Param("precioMin") double precioMin, @Param("precioMax") double precioMax);
}
