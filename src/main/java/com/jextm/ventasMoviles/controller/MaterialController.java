package com.jextm.ventasMoviles.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		material.setEstado('A');
		if (rs.hasErrors()) {
			model.setViewName("materialForm");
			model.addObject("message", "Debe LLenar Todos los Campos");
		}
		materialService.saveMaterial(material);
		return model;
	}
	
}
