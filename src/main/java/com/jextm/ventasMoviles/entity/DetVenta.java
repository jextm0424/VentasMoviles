package com.jextm.ventasMoviles.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import com.jextm.ventasMoviles.entity.id.DetVentaId;


@Entity
@Table(name = "t_detalle_venta", catalog = "ventasmoviles")
@AssociationOverrides({
		@AssociationOverride(name = "pk.venta",
			joinColumns = @JoinColumn(name = "idVenta")),
		@AssociationOverride(name = "pk.material",
			joinColumns = @JoinColumn(name = "idMaterial")) })
public class DetVenta implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	DetVentaId pk = new DetVentaId();
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="importe")
	private Double importe;
	public DetVentaId getPk() {
		return pk;
	}
	public void setPk(DetVentaId pk) {
		this.pk = pk;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public DetVenta(DetVentaId pk, int cantidad, Double importe) {
		super();
		this.pk = pk;
		this.cantidad = cantidad;
		this.importe = importe;
	}
	
	
	public DetVenta() {
		// TODO Auto-generated constructor stub
	}
	

}
