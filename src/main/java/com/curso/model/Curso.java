package com.curso.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	@Id
	private String codCurso;
	private String nombre;
	private Double duracion;
	private Double precio;
	
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Curso(String codCurso, String nombre, Double duracion, Double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}


	public String getCodCurso() {
		return codCurso;
	}


	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getDuracion() {
		return duracion;
	}


	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
	

}
