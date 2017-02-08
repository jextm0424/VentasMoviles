package com.jextm.ventasMoviles.controller;

import java.util.Date;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Cliente;
import com.jextm.ventasMoviles.entity.Venta;
import com.jextm.ventasMoviles.service.ClienteService;
import com.jextm.ventasMoviles.service.DetVentaService;
import com.jextm.ventasMoviles.service.MaterialService;
import com.jextm.ventasMoviles.service.VentaService;

@Controller
public class VentasController {
	
	@Autowired
	private VentaService ventasService;
	@Autowired
	private DetVentaService detVentaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value="/ventas")
	public String index(){
		return "ventasIndex";
	}
	@RequestMapping(value="/verVentas")
	public ModelAndView verVentas(/*String fecha*/){
		ModelAndView model = new ModelAndView("verVentas");
		model.addObject("ventas", ventasService.getAll());
		return model;
	}
	@RequestMapping(value="/modificarVenta")
	public ModelAndView modificarVenta(int idVenta){
		ModelAndView model = new ModelAndView("modificarVenta");
		model.addObject("detVenta", detVentaService.findByVenta(idVenta));
		return model;
	}
	@RequestMapping(value="/modVenta", method = GET)
	public String modVenta(String detalle, Date fecha, int idVenta, int idCliente){
		Cliente cliente = clienteService.findByOne(idCliente);
		Venta venta = ventasService.findOne(idVenta);
		venta.setFechaVenta(fecha);
		
		return "";
	}
	
}
