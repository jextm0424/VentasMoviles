package com.jextm.ventasMoviles.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.service.PersonalService;
import com.jextm.ventasMoviles.service.RolService;
import com.jextm.ventasMoviles.service.TerritorioService;
import com.jextm.ventasMoviles.service.TipoService;

@Controller
public class PersonalController {
	@Autowired
	private PersonalService personalService;
	@Autowired
	private TipoService tipoService;
	@Autowired
	private RolService rolService;
	@Autowired
	private TerritorioService territorioService;
	
	
	@RequestMapping(value="/personal")
	public String index(){
		return "personalIndex";
	}
	@RequestMapping(value="/addPersonal", method = RequestMethod.POST)
	public ModelAndView addPersonal(@Valid @ModelAttribute("peModel") Personal personal){
		ModelAndView model = new ModelAndView("personalIndex");
		Personal exisUsuario = personalService.findByUsuario(personal.getUsuario().toUpperCase());
		
		if (exisUsuario!=null && personal.getIdPersonal()==0) {
			model.addObject("message", "El usuario Ya Existe");
			model.addObject("roles", rolService.getAll());
			model.addObject("tipos", tipoService.getAll());
			model.addObject("territorios", territorioService.getAll());	
			if(personal.getIdPersonal() == 0){
				model.setViewName("addPersonal");
			}else{
				model.setViewName("modifyPersonal");
			}
			return model;
		}
			if (personal.getIdPersonal() == 0) {
				personal.setEstado('A');
			}
			if ((personal.getTerritorio().getIdTerritorio()==0 || personal.getTipo().getIdTipo().equals(""))&& personal.getRol().getIdRol() == 'V') {
				model.addObject("message", "Terrotorio y Tipo son obligatorios para el Rol Vendedor");
				model.addObject("roles", rolService.getAll());
				model.addObject("tipos", tipoService.getAll());
				model.addObject("territorios", territorioService.getAll());		
				if(personal.getIdPersonal() == 0){
					model.setViewName("addPersonal");
				}else{
					model.setViewName("modifyPersonal");
				}
				return model;
			}
			if (personal.getRol().getIdRol()=='A') {
				personal.setTerritorio(null);
				personal.setTipo(null);
			}
			try {
				personal.setUsuario(personal.getUsuario().toUpperCase());
				personalService.savePersonal(personal);
			} catch (HibernateException e) {
				model.addObject("message", "No se Pudo Agregar o Modificar Personal");
				model.addObject("roles", rolService.getAll());
				model.addObject("tipos", tipoService.getAll());
				model.addObject("territorios", territorioService.getAll());
				model.setViewName("addPersonal");
				return model;
			}
		
		model.addObject("message", "Se realizo Correctamente");
		return model;
	}
	
	@RequestMapping(value="/addPersonal",method= RequestMethod.GET)
	public ModelAndView addPersonalForm(){
		ModelAndView model = new ModelAndView("addPersonal");
		model.addObject("roles", rolService.getAll());
		model.addObject("tipos", tipoService.getAll());
		model.addObject("peModel", new Personal());
		model.addObject("territorios", territorioService.getAll());
		return model;
	}
	@RequestMapping(value="/modifyPersonal",method= RequestMethod.GET)
	public ModelAndView modidyPersonal(int idPersonal){
		Personal personal = personalService.findOne(idPersonal);
		ModelAndView model = new ModelAndView("modifyPersonal");
		model.addObject("roles", rolService.getAll());
		model.addObject("tipos", tipoService.getAll());
		model.addObject("territorios", territorioService.getAll());
		model.addObject("peModel", personal);
		return model;
	}
	@RequestMapping(value="/personalList")
	public ModelAndView personalList(@RequestParam(value="tipo", required=false) String tipo, @RequestParam(value="parametro", required=false) String parametro){
		ModelAndView model = new ModelAndView("personalList");
		List<Personal> personales = null;
		if (tipo!=null && parametro != null && !tipo.trim().equals("") && !parametro.trim().equals("")) {
			switch (tipo) {
			case "N":
				model.addObject("personales", personalService.findByName(parametro));
				break;
			case "C":
				personales = new ArrayList<Personal>();
				try{
					personales.add(personalService.findOne(Integer.parseInt(parametro)));
					model.addObject("personales", personales);
				}
				catch(NumberFormatException e){
					model.addObject("message", "Codigo Incorrecto");
					System.out.println("Codigo Incorrecto");
				}
				break;
			default:
				model.addObject("personales", personalService.finAll());
				break;
			}
		}else{
			model.addObject("personales", personalService.finAll());
		}
		return model;
	}
}
