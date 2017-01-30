package com.jextm.ventasMoviles.entity.id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.jextm.ventasMoviles.entity.Material;
import com.jextm.ventasMoviles.entity.Venta;

@Embeddable
public class DetVentaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Venta venta;
	@ManyToOne
	private Material material;
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public DetVentaId(Venta venta, Material material) {
		super();
		this.venta = venta;
		this.material = material;
	}
	
	public DetVentaId() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
