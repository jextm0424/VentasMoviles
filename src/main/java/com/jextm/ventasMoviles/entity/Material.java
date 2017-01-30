package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_material")
public class Material{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMaterial;
		
	@Column(name="material")
	private String material;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="peso")
	private Double peso;
	
	@Column(name="estado")
	private Character estado;

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Material(int idMaterial, String material, Double precio,
			Double peso, Character estado) {
		super();
		this.idMaterial = idMaterial;
		this.material = material;
		this.precio = precio;
		this.peso = peso;
		this.estado = estado;
	}

	public Material() {
		// TODO Auto-generated constructor stub
	}
	
	

}
