package com.jextm.ventasMoviles.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Venta;
import com.jextm.ventasMoviles.service.UbigeoService;
import com.jextm.ventasMoviles.service.VentaService;

@Controller
public class ConsultasController {
	@Autowired
	private VentaService ventaService;
	@Autowired
	private UbigeoService ubigeoService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/consulta")
	public ModelAndView index(@RequestParam(value="tipo",required=false)String tipo,@RequestParam(value="parametro",required=false)String parametro){
		ModelAndView model = new ModelAndView("consulta");
		if (parametro==null || !parametro.trim().equals("")) {
			model.addObject("message", "No se encontraron resultados");
			return model;
		}
		model.addObject("ubigeos", ubigeoService.getAll());
		try{
			switch (tipo) {
			case "VE":
				model.addObject("lista", ventaService.findByVendedor(Integer.parseInt(parametro)));
				break;
			case "CL":
				model.addObject("lista", ventaService.findByCliente(Integer.parseInt(parametro)));
				break;
			case "MO":
				model.addObject("lista", ventaService.findByModulo(parametro));
				break;
			case "PR":
				model.addObject("lista", ventaService.findByProducto(Integer.parseInt(parametro)));
				break;
			case "DI":
				model.addObject("lista", ventaService.findByDia(Integer.parseInt(parametro)));
				break;
			case "GI":
				model.addObject("lista", ventaService.findByGiro(parametro.charAt(0)));
				break;
			case "DS":
				model.addObject("lista", ventaService.findByDistrito(Integer.parseInt(parametro)));
				break;
			case "FE":
				model.addObject("lista", ventaService.findByFecha(new Date(parametro)));
				break;
			default:
				model.addObject("lista", ventaService.getAll());
				break;
			}
		}catch (NumberFormatException e) {
			model.addObject("message", "No se encontraron resultados");
		}
		return model;
	}
	
}
