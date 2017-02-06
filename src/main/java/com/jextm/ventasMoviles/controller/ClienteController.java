package com.jextm.ventasMoviles.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jextm.ventasMoviles.entity.Cliente;
import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.service.ClienteService;
import com.jextm.ventasMoviles.service.GiroService;
import com.jextm.ventasMoviles.service.TipoDocumentoService;

@Controller
public class ClienteController {
	@Autowired
	private GiroService giroService;
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	@Autowired
	private ClienteService clienteSerivice;

	
	@RequestMapping(value="/cliente")
	public String index(){
		return "clienteIndex";
	}
	@RequestMapping(value="/cagregar")
	public ModelAndView form(){
		ModelAndView model = new ModelAndView("clienteForm");
		model.addObject("cliModel", new Cliente());
		model.addObject("giros", giroService.getAll());
		model.addObject("tipoDocs", tipoDocumentoService.getAll());
		return model;
	}
	@RequestMapping(value="/cagregar", method = RequestMethod.POST)
	public ModelAndView addCliente(@Valid @ModelAttribute("cliModel") Cliente cliente, BindingResult br, HttpServletRequest request){
		ModelAndView model = new ModelAndView("clienteIndex");
		cliente.setEstado('A');
		cliente.setPersonal((Personal)request.getSession().getAttribute("user"));
		if (br.hasErrors()) {
			model.addObject("giros", giroService.getAll());
			model.addObject("tipoDoc", tipoDocumentoService.getAll());
			model.addObject("message", "Debe Llenar Todos los Campos");
			model.setViewName("clienteForm");
			return model;
		}
		if (cliente !=null) {
			Cliente dni = clienteSerivice.findByNroDoc(cliente.getNroDocumento());
			if (dni!=null) {
				model.addObject("giros", giroService.getAll());
				model.addObject("tipoDoc", tipoDocumentoService.getAll());
				model.addObject("message", "El NRO DE DOCUMENTO YA EXISTE");
				model.setViewName("clienteForm");
				return model;
			}else{
				try{
					clienteSerivice.saveCliente(cliente);
				}catch(Exception e){
					model.addObject("giros", giroService.getAll());
					model.addObject("tipoDoc", tipoDocumentoService.getAll());
					model.addObject("message", "Error al Grabar Datos");
					model.setViewName("clienteForm");
					return model;
				}
			}
		}
		model.addObject("message", "Ingresado Correctamente");
		return model;
	}
	@RequestMapping(value="/cBuscar")
	public String buscarCliente(){
		return "buscarCliente";
	}
	@RequestMapping(value="/buscarCliente")
	public ModelAndView findClientes(int tipo, String txtTipo){
		ModelAndView model = new ModelAndView("buscarCliente");
		List<Cliente> lista =  new ArrayList<Cliente>();
		try{
			switch (tipo) {
			case 0: //Codigo de Cliente
				lista.add(clienteSerivice.findByOne(Integer.parseInt(txtTipo)));
				break;
			case 1: //Número de Documento
				lista.add(clienteSerivice.findByNroDoc(Integer.parseInt(txtTipo)));
				break;
			case 2: //Nombre
				lista = clienteSerivice.findByName(txtTipo);
				break;
			case 3: //Apellido
				lista = null;
				break; 
			case 4: //Dia De Visita
				lista = null;
				break;
			default:
				lista = clienteSerivice.getClientes();
				break;
			}
			if (lista!=null) {
				if(lista.size()!=0){
					model.addObject("clientes", lista);
				}else{
					model.addObject("message","No se Encontraron Resultados");
				}
			}else{
				model.addObject("message","No se Encontraron Resultados");
			}
		}catch(NumberFormatException e){
			model.addObject("message","No se Encontraron Resultados");
		}
		return model;
	}
	@RequestMapping(value="/editarCliente")
	public ModelAndView modifCliente(int idCliente){
		ModelAndView model = new ModelAndView("clienteEdit");
		Cliente cliente = clienteSerivice.findByOne(idCliente);
		model.addObject("cliModel", cliente);
		model.addObject("giros", giroService.getAll());
		model.addObject("tipoDocs", tipoDocumentoService.getAll());
		return model;
	}
	@RequestMapping(value="/editarCliente",method = RequestMethod.POST)
	public ModelAndView modifCli(@Valid @ModelAttribute("cliModel") Cliente cliente, BindingResult br){
		ModelAndView model = new ModelAndView("index");
		if (br.hasErrors()) {
			model.addObject("giros", giroService.getAll());
			model.addObject("tipoDoc", tipoDocumentoService.getAll());
			model.addObject("message", "Debe Llenar Todos los Campos Correctamente");
			model.setViewName("clienteEdit");
		}
		if (cliente !=null) {
			try{
				clienteSerivice.saveCliente(cliente);
			}catch(Exception e){
				model.addObject("giros", giroService.getAll());
				model.addObject("tipoDoc", tipoDocumentoService.getAll());
				model.addObject("message", "Error al Grabar Datos");
				model.setViewName("clienteForm");
				return model;
			}
		}
		model.addObject("message", "Modifiado Correctamente");
		return model;
	}
}
