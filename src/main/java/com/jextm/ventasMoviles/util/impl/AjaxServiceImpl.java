package com.jextm.ventasMoviles.util.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;

import com.jextm.ventasMoviles.entity.Cliente;
import com.jextm.ventasMoviles.entity.Giro;
import com.jextm.ventasMoviles.entity.Material;
import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.entity.Ubigeo;
import com.jextm.ventasMoviles.entity.repository.ClienteRepository;
import com.jextm.ventasMoviles.entity.repository.DetVentaRepository;
import com.jextm.ventasMoviles.entity.repository.GiroRepository;
import com.jextm.ventasMoviles.entity.repository.MaterialRepository;
import com.jextm.ventasMoviles.entity.repository.PersonalRepository;
import com.jextm.ventasMoviles.entity.repository.UbigeoRepository;
import com.jextm.ventasMoviles.entity.repository.VentaRepository;
import com.jextm.ventasMoviles.util.AjaxService;

public class AjaxServiceImpl implements AjaxService{

	@Autowired
	private VentaRepository ventaRepositoy;
	@Autowired
	private DetVentaRepository DetVentaRepository;
	@Autowired
	private PersonalRepository personalRepository;
	@Autowired
	private UbigeoRepository ubigeoService;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private GiroRepository giroRepository;
 
	
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

	@Override
	public String getDatosClientes() {
		JSONArray json = null;
		List<Cliente> lista = null;
		try {
			lista = clienteRepository.findAll();
			json = new JSONArray(lista);
		} catch (Exception e) {
			System.out.println("Error:"+ e.getMessage() );
		}
		return json.toString();
	}

	@Override
	public String getDatosProductos() {
		JSONArray json = null;
		List<Material> lista = null;
		try {
			lista = materialRepository.findAll();
			json = new JSONArray(lista);
		} catch (HibernateException e) {
			System.out.println("Error:"+ e.getMessage() );
		}
		return json.toString();
	}

	@Override
	public String getDatosGiro() {
		JSONArray json = null;
		List<Giro> lista = null;
		try {
			lista = giroRepository.findAll();
			json = new JSONArray(lista);
		} catch (HibernateException e) {
			System.out.println("Error:"+ e.getMessage() );
		}
		return json.toString();
	}

	@Override
	public String getDatosDistrito() {
		JSONArray json = null;
		List<Ubigeo> lista = null;
		try {
			lista = ubigeoService.findAll();
			json = new JSONArray(lista);
		} catch (HibernateException e) {
			System.out.println("Error:"+ e.getMessage() );
		}
		return json.toString();
	}
}
