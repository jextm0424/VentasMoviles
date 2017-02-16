package com.jextm.ventasMoviles.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int idCliente;
	@Column(name="direccion")
	private String direccion;
	@Column(name="nroDocumento")
	private int nroDocumento;
	@Column(name = "estado")
	private Character estado;
	@Column(name = "x")
	private BigDecimal x;
	@Column(name = "y")
	private BigDecimal y;
	@ManyToOne
	@JoinColumn(name="fk_personal")
	private Personal personal;
	@ManyToOne
	@JoinColumn(name="fk_giro")
	private Giro giro;
	@ManyToOne
	@JoinColumn(name="fk_tpDoc")
	private TipoDocumento tipoDocumento;
	@Column(name="diaVisita")
	private int diaVisita;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name = "ubigeo")
	private String ubigeo;
	@Column( name = "modulo")
	private String modulo;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public Character getEstado() {
		return estado;
	}
	public void setEstado(Character estado) {
		this.estado = estado;
	}
	public BigDecimal getX() {
		return x;
	}
	public void setX(BigDecimal x) {
		this.x = x;
	}
	public BigDecimal getY() {
		return y;
	}
	public void setY(BigDecimal y) {
		this.y = y;
	}
	public Personal getPersonal() {
		return personal;
	}
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	public Giro getGiro() {
		return giro;
	}
	public void setGiro(Giro giro) {
		this.giro = giro;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getDiaVisita() {
		return diaVisita;
	}
	public void setDiaVisita(int diaVisita) {
		this.diaVisita = diaVisita;
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
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public Cliente(int idCliente, String direccion, int nroDocumento, Character estado, BigDecimal x, BigDecimal y,
			Personal personal, Giro giro, TipoDocumento tipoDocumento, int diaVisita, String nombre, String apellido,
			String ubigeo, String modulo) {
		super();
		this.idCliente = idCliente;
		this.direccion = direccion;
		this.nroDocumento = nroDocumento;
		this.estado = estado;
		this.x = x;
		this.y = y;
		this.personal = personal;
		this.giro = giro;
		this.tipoDocumento = tipoDocumento;
		this.diaVisita = diaVisita;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ubigeo = ubigeo;
		this.modulo = modulo;
	}
	public Cliente(String direccion, int nroDocumento, Character estado, BigDecimal x, BigDecimal y,
			Personal personal, Giro giro, TipoDocumento tipoDocumento, int diaVisita, String nombre, String apellido,
			String ubigeo, String modulo) {
		super();
		this.direccion = direccion;
		this.nroDocumento = nroDocumento;
		this.estado = estado;
		this.x = x;
		this.y = y;
		this.personal = personal;
		this.giro = giro;
		this.tipoDocumento = tipoDocumento;
		this.diaVisita = diaVisita;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ubigeo = ubigeo;
		this.modulo = modulo;
	}
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
}