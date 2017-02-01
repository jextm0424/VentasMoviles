package com.jextm.ventasMoviles.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Material;
import com.jextm.ventasMoviles.service.MaterialService;

@Controller
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value="/material")
	public String index(){
		return "materialIndex";
	}
	@RequestMapping(value="/addMaterial")
	public ModelAndView addMaterial(){
		ModelAndView model= new ModelAndView("materialForm");
		model.addObject("matModel", new Material());
		
		return model;
	}
	@RequestMapping(value="/addMaterial", method = RequestMethod.POST)
	public ModelAndView agregarMaterial(@Valid @ModelAttribute("matModel")Material material, BindingResult rs){
		ModelAndView model = new ModelAndView("index");
		if(material.getIdMaterial() == 0 ){
			material.setEstado('A');
		}
		if (rs.hasErrors()) {
			model.setViewName("materialForm");
			model.addObject("message", "Debe LLenar Todos los Campos");
			return model;
		}
		model.addObject("message", "Agregado Correctamente");
		materialService.saveMaterial(material);
		return model;
	}
	@RequestMapping(value="/modifyMaterial",method=RequestMethod.GET)
	public ModelAndView modifyMaterial(int idMaterial){
		ModelAndView model = new ModelAndView("modMaterial");
		model.addObject("matModel", materialService.findOne(idMaterial));
		return model;
	}
	@RequestMapping(value="/materiaList")
	public ModelAndView materialList(@RequestParam(value="tipoFiltro", required=false) String tipoFiltro,@RequestParam( value="parametro", required=false) String parametro){
		ModelAndView model = new ModelAndView("listMaterial");
		List<Material> materiales = null;
		System.out.println("Filtro: "+tipoFiltro);
		if(tipoFiltro == null || parametro == null){
			return model;
		}else{
			if(!tipoFiltro.trim().equals("") && !parametro.trim().equals("")){
				switch (tipoFiltro) {
				case "E":
					materiales = materialService.getByEstado(parametro.charAt(0));
					break;
				case "M":
					materiales = materialService.getByName(parametro);
					break;
				case "I":
					materiales = new ArrayList<Material>();
					try{
					materiales.add(materialService.findOne(Integer.parseInt(parametro)));
					}catch (NumberFormatException e) {
						model.addObject("message", "No se Encontraron Resultados");
					}
					break;
				default:
					materiales = materialService.getAll();
					break;
				}
			}else{
				model.addObject("message", "No se Encontraron Resultados");
			}
		}
		model.addObject("materiales", materiales);
		return model;
	}
}
