package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.CursoFormacion;
import com.curso.model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService{
	
	@Autowired
	RestTemplate template;
	
	private String url = "http://localhost:8080/";
	
	//Lista de cursos existentes
	@Override
	public List<Formacion> formacionesExistentes(){
		List<CursoFormacion> cursos = Arrays.asList(template.getForObject(url+"cursos", CursoFormacion[].class));
		
		List<Formacion> formaciones = new ArrayList();
		for (CursoFormacion c:cursos) {
			Formacion f = new Formacion();
			f.setPrecio(c.getPrecio());
			f.setAsignaturas(c.getDuracion()>50 ? 10:5);
			f.setCurso(c.getNombre());
			formaciones.add(f);
		}
		return formaciones;
		
	}
	
	//Alta curso
	@Override
	public void nuevaFormacion (Formacion formacion) {
		CursoFormacion cf = new CursoFormacion();
		cf.setNombre(formacion.getCurso());
		double duracion = formacion.getAsignaturas()*10;
		cf.setDuracion(duracion);
		cf.setCodCurso(formacion.getCurso().substring(0,3)+duracion);
		cf.setPrecio(formacion.getPrecio());
		
		template.postForLocation(url+"curso", cf);	
	}
	

}
