package com.jextm.ventasMoviles.entity.model;

public class ClientesModel {
	private int idCliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String nroDocumento;
	private String tipoDocumento;
	private String giro;
	private String modulo;
	private String ubigeo;
	private String x;
	private String y;
	private String diaVisita;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	public void setApellido(String apelido) {
		this.apellido = apelido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getGiro() {
		return giro;
	}
	public void setGiro(String giro) {
		this.giro = giro;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getDiaVisita() {
		return diaVisita;
	}
	public void setDiaVisita(String diaVisita) {
		this.diaVisita = diaVisita;
	}
	public ClientesModel(int idCliente, String nombre, String apellido, String direccion,
			String nroDocumento, String tipoDocumento, String giro, String modulo, String ubigeo, String x, String y,
			String diaVisita) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.nroDocumento = nroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.giro = giro;
		this.modulo = modulo;
		this.ubigeo = ubigeo;
		this.x = x;
		this.y = y;
		this.diaVisita = diaVisita;
	}
	
	public ClientesModel() {
		// TODO Auto-generated constructor stub
	}
}
