package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_rol")
public class Rol {
	
	@Id
	private Character idRol;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estado")
	private Character estado;

	public Character getIdRol() {
		return idRol;
	}

	public void setIdRol(Character idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Rol(Character idRol, String descripcion, Character estado) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public Rol() {
		// TODO Auto-generated constructor stub
	}
	
	

}
