package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_giro")
public class Giro {

	@Id
	private Character idGiro;
	
	@Column(name="giro")
	private String giro;

	public Giro(Character idGiro, String giro) {
		super();
		this.idGiro = idGiro;
		this.giro = giro;
	}
	
	public Giro() {
		// TODO Auto-generated constructor stub
	}

	public Character getIdGiro() {
		return idGiro;
	}

	public void setIdGiro(Character idGiro) {
		this.idGiro = idGiro;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}
	
	
	
	
}
