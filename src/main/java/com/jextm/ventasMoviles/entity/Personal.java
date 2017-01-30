package com.jextm.ventasMoviles.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_personal")
public class Personal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPersonal;
	
	@Column(name="usuario", unique= true)
	private String usuario;
	
	@Column(name="clave")
	private String clave;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name = "dni")
	private int dni;
	
	@Column(name="estado")
	private Character estado;
	
	@ManyToOne
	@JoinColumn(name="fk_idrol")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name="fk_idTerritorio")
	private Territorio territorio;

	public int getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Territorio getTerritorio() {
		return territorio;
	}

	public void setTerritorio(Territorio territorio) {
		this.territorio = territorio;
	}

	public Personal(int idPersonal, String usuario, String clave,
			String nombre, String apellido, int dni, Character estado, Rol rol,
			Territorio territorio) {
		super();
		this.idPersonal = idPersonal;
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.estado = estado;
		this.rol = rol;
		this.territorio = territorio;
	}
	
	public Personal(String usuario, String clave,
			String nombre, String apellido, int dni, Character estado, Rol rol,
			Territorio territorio) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.estado = estado;
		this.rol = rol;
		this.territorio = territorio;
	}

	public Personal() {
		// TODO Auto-generated constructor stub
	}

}
