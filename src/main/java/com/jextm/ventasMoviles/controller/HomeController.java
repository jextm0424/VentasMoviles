package com.jextm.ventasMoviles.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.service.PersonalService;


@Controller
public class HomeController {

	@Autowired
	private PersonalService personalService;
	
	@RequestMapping(value = "/")
	public String index(){
		return "index";
	}
	@RequestMapping(value = "/login")
	public ModelAndView login(){
		ModelAndView model = new ModelAndView("exclude/login");
		model.addObject("lgModel", new Personal());
		return model;
	}
	@RequestMapping(value= "login", method = RequestMethod.POST)
	public ModelAndView postLogin(@Valid @ModelAttribute("lgModel") Personal personal, HttpServletRequest request){
		ModelAndView model = new ModelAndView("exclude/login");
		Personal usuario = personalService.login(personal.getUsuario().toUpperCase(), personal.getClave());
		if (usuario != null) {
			if (usuario.getRol().getIdRol().equals('A')) {
				model.setViewName("redirect:/");
				request.getSession().setAttribute("user", usuario);
			}else{
				model.addObject("message", "Solo el administrador puede entrar a la pagina");
			}
		}else{
			model.addObject("message", "Usuario o Clave Incorrectos");
		}
		return model;
	}
	
}
