package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_tipo_documento")
public class TipoDocumento {
	



	@Id
	private Character idTipoDoc;
	
	@Column(name="tipoDocumento")
	private String tipoDocumento;
	
	
	public Character getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(Character idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public TipoDocumento(Character idTipoDoc, String tipoDocumento) {
		super();
		this.idTipoDoc = idTipoDoc;
		this.tipoDocumento = tipoDocumento;
	}

	public TipoDocumento() {
		// TODO Auto-generated constructor stub
	}
	
}
