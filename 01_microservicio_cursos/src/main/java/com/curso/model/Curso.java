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
	private double duracion;
	private double precio;
	
	
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Curso(String codCurso, String nombre, double duracion, double precio) {
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


	public double getDuracion() {
		return duracion;
	}


	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	

}
