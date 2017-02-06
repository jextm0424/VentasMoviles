package com.jextm.ventasMoviles.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.service.PersonalService;
import com.jextm.ventasMoviles.service.RolService;
import com.jextm.ventasMoviles.service.TipoService;

@Controller
public class PersonalController {
	@Autowired
	private PersonalService personalService;
	@Autowired
	private TipoService tipoService;
	@Autowired
	private RolService rolService;
	
	
	@RequestMapping(value="/personal")
	public String index(){
		return "personalIndex";
	}
	@RequestMapping(value="/addPersonal", method = RequestMethod.POST)
	public ModelAndView addPersonal(@Valid @ModelAttribute("peModel") Personal personal, BindingResult br){
		ModelAndView model = new ModelAndView("indexPersonal");
		if (personal.getIdPersonal() == 0) {
			personal.setEstado('A');
		}
		if (br.hasErrors()) {
			model.addObject("roles", rolService.getAll());
			model.addObject("tipos", tipoService.getAll());
			model.addObject("message", "Debe Agregar todos los campos correctamente");
			model.setViewName("addPersonal");
			return model;
		}
		try {
			personalService.savePersonal(personal);
		} catch (HibernateException e) {
			model.addObject("message", "No se Pudo Agregar o Modificar Personal");
			model.addObject("roles", rolService.getAll());
			model.addObject("tipos", tipoService.getAll());
			model.setViewName("addPersonal");
			return model;
		}
		model.addObject("message", "Se realizo Correctamente");
		return model;
	}
	
	@RequestMapping(value="/addPersonal",method= RequestMethod.POST)
	public ModelAndView addPersonalForm(){
		ModelAndView model = new ModelAndView("addPersonal");
		model.addObject("roles", rolService.getAll());
		model.addObject("tipos", tipoService.getAll());
		model.addObject("peModel", new Personal());
		return model;
	}
	@RequestMapping(value="/modifyPersonal",method= RequestMethod.GET)
	public ModelAndView modidyPersonal(int idPersonal){
		Personal personal = personalService.findOne(idPersonal);
		ModelAndView model = new ModelAndView("addPersonal");
		model.addObject("roles", rolService.getAll());
		model.addObject("tipos", tipoService.getAll());
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
