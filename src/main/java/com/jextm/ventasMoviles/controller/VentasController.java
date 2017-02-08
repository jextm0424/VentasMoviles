package com.jextm.ventasMoviles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jextm.ventasMoviles.entity.DetVenta;
import com.jextm.ventasMoviles.entity.Material;
import com.jextm.ventasMoviles.entity.Venta;
import com.jextm.ventasMoviles.entity.id.DetVentaId;
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
	public String modVenta(String detalle,int idVenta, RedirectAttributes ra){
		double pesoTotal = 0.0;
		double precioTotal = 0.0;
		Venta venta = ventasService.findOne(idVenta);
		boolean wasDelete =  detVentaService.deleteDetVenta(idVenta);
		if(wasDelete){
			String[] posiciones = detalle.split(";");
			for (int i = 0; i < posiciones.length; i++) {
				int mat = Integer.parseInt(posiciones[i].split("-")[0]);
				int cantidad = Integer.parseInt(posiciones[i].split("-")[1]);
				double peso= Double.parseDouble(posiciones[i].split("-")[2]);
				double precio= Double.parseDouble(posiciones[i].split("-")[3]);
				Material material= materialService.findOne(mat);
				DetVenta detVenta = new DetVenta();
				DetVentaId pk = new  DetVentaId();
				pk.setVenta(venta);
				pk.setMaterial(material);
				detVenta.setPk(pk);
				detVenta.setCantidad(cantidad);
				detVenta.setImporte(precio);
				precioTotal+=precio;
				pesoTotal+=peso;
				detVentaService.saveDetVenta(detVenta);
			}
			venta.setPesoTotal(pesoTotal);
			venta.setPrecioTotal(precioTotal);
			venta = ventasService.saveVenta(venta);
			ra.addFlashAttribute("message", "Modificado Correctamente");
			return "redirect:/verVentas";
		}
		ra.addFlashAttribute("message", "Error al Modificar");
		return "redirect:/modificarVenta?idVenta="+idVenta;
		
	}
	
}
