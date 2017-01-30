package com.jextm.ventasMoviles.util.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jextm.ventasMoviles.entity.repository.VentaRepository;
import com.jextm.ventasMoviles.util.AjaxService;

public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private VentaRepository ventaRepositoy;
	
	@Override
	public String deleteVenta(int idVenta) {
		try{
			ventaRepositoy.delete(idVenta);
		}catch(HibernateException e){
			System.out.println("Error:"+ e.getMessage() );
			return "E";
		}
		return "S";
	}



}
