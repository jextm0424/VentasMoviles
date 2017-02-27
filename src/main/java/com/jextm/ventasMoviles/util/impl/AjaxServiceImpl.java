package com.jextm.ventasMoviles.util.impl;

import java.util.List;
import org.hibernate.HibernateException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.entity.repository.DetVentaRepository;
import com.jextm.ventasMoviles.entity.repository.PersonalRepository;
import com.jextm.ventasMoviles.entity.repository.VentaRepository;
import com.jextm.ventasMoviles.util.AjaxService;

public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private VentaRepository ventaRepositoy;
	@Autowired
	private DetVentaRepository DetVentaRepository;
	@Autowired
	private PersonalRepository personalRepository;
	
	@Override
	public String deleteVenta(int idVenta) {
		try{
			DetVentaRepository.deleteDetallesVentasById(idVenta);
			ventaRepositoy.delete(idVenta);
			System.out.println("Se Borro la venta: "+ idVenta);
		}catch(HibernateException e){
			System.out.println("Error:"+ e.getMessage() );
			return "E";
		}
		return "S";
	}

	@Override
	public String getDatosPersonales() {
		List<Personal> lista = null;
		JSONArray json= null;
		try{
			lista =  personalRepository.findAll();
			json = new JSONArray(lista);
		}catch
		(HibernateException e)
		{
			System.out.println("Error:"+ e.getMessage() );
		}
		return json.toString();
	}



}
