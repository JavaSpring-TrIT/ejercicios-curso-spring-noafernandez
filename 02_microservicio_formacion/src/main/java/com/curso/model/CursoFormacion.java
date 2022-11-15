package com.curso.model;

public class CursoFormacion {
	private String codCurso;
	private String nombre;
	private Double duracion;
	private Double precio;
	
	public CursoFormacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CursoFormacion(String codCurso, String nombre, Double duracion, Double precio) {
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
