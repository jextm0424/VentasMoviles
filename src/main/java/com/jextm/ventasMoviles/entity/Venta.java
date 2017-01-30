package com.jextm.ventasMoviles.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_venta")
public class Venta implements Serializable{
	
	/**
	 * gg
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVenta;
	
	@Column(name="precioTotal")
	private Double precioTotal;
	
	@Column(name="pesoTotal")
	private Double pesoTotal;
	
	@Column(name="fechaVenta")
	private Date fechaVenta;
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;
	


	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public Venta(int idVenta, Double precioTotal, Double pesoTotal,
			Date fechaVenta, Cliente cliente) {
		super();
		this.idVenta = idVenta;
		this.precioTotal = precioTotal;
		this.pesoTotal = pesoTotal;
		this.fechaVenta = fechaVenta;
		this.cliente = cliente;
	}

	public Venta() {
		// TODO Auto-generated constructor stub
	}

}
