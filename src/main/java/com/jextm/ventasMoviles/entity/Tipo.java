package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_tipo")
public class Tipo {
	
	@Id
	private Character idTipo;
	@Column(name="descripcion")
	private String descripcion;
	public Character getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Character idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Tipo(Character idTipo, String descripcion) {
		super();
		this.idTipo = idTipo;
		this.descripcion = descripcion;
	}
	
	public Tipo() {
		// TODO Auto-generated constructor stub
	}
}
