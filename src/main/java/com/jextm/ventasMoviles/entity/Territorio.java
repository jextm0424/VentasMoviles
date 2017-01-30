package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_territorio")
public class Territorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTerritorio;
	
	@Column(name="descripcion")
	private String descripcion;

	public int getIdTerritorio() {
		return idTerritorio;
	}

	public void setIdTerritorio(int idTerritorio) {
		this.idTerritorio = idTerritorio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Territorio(int idTerritorio, String descripcion) {
		super();
		this.idTerritorio = idTerritorio;
		this.descripcion = descripcion;
	}
	
	public Territorio() {
		// TODO Auto-generated constructor stub
	}
	

}
