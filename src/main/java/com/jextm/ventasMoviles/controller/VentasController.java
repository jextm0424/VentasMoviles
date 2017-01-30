package com.jextm.ventasMoviles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.service.DetVentaService;
import com.jextm.ventasMoviles.service.VentaService;

@Controller
public class VentasController {
	
	@Autowired
	private VentaService ventasService;
	@Autowired
	private DetVentaService detVentaService;
	
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
	
}
