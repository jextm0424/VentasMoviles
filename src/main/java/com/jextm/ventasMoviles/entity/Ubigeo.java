package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_ubigeo")
public class Ubigeo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUbigeo;
	
	@Column(name="descripcion")
	private String descripcion;

	public int getIdUbigeo() {
		return idUbigeo;
	}

	public void setIdUbigeo(int idUbigeo) {
		this.idUbigeo = idUbigeo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ubigeo(int idUbigeo, String descripcion) {
		super();
		this.idUbigeo = idUbigeo;
		this.descripcion = descripcion;
	}
	
	public Ubigeo() {
		// TODO Auto-generated constructor stub
	}

}
