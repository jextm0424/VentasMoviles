package com.jextm.ventasMoviles.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jextm.ventasMoviles.entity.Cliente;
import com.jextm.ventasMoviles.entity.DetVenta;
import com.jextm.ventasMoviles.entity.Giro;
import com.jextm.ventasMoviles.entity.Material;
import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.entity.TipoDocumento;
import com.jextm.ventasMoviles.entity.Venta;
import com.jextm.ventasMoviles.entity.id.DetVentaId;
import com.jextm.ventasMoviles.entity.model.ClientesModel;
import com.jextm.ventasMoviles.service.ClienteService;
import com.jextm.ventasMoviles.service.DetVentaService;
import com.jextm.ventasMoviles.service.GiroService;
import com.jextm.ventasMoviles.service.MaterialService;
import com.jextm.ventasMoviles.service.PersonalService;
import com.jextm.ventasMoviles.service.TipoDocumentoService;
import com.jextm.ventasMoviles.service.UbigeoService;
import com.jextm.ventasMoviles.service.VentaService;
import com.jextm.ventasMoviles.util.Constans;
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class RestController {
	@Autowired
	private MaterialService materialService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PersonalService personalService;
	@Autowired
	private VentaService ventaService;
	@Autowired
	private DetVentaService detVentaService;
	@Autowired
	private TipoDocumentoService tipoDocumentoservice;
	@Autowired
	private GiroService giroService;
	@Autowired
	private UbigeoService ubigeoService;
	@RequestMapping(value = "/restLogin", method =RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String getClientes(String usuario, String clave){
		int dia = getDay();
		usuario = usuario.toUpperCase();
		Map json = new HashMap();
		Personal personal = personalService.login(usuario, clave);
		if(personal!=null){
			List<Cliente> clientes =clienteService.findByPersonalDia(personal.getIdPersonal(), dia);
			List<ClientesModel> modelos = new ArrayList<ClientesModel>();
			for (Cliente cliente : clientes) {
				ClientesModel model = new ClientesModel();
				model.setIdCliente(cliente.getIdCliente());
				model.setApellido(cliente.getApellido());
				model.setDireccion(cliente.getDireccion());
				model.setGiro(cliente.getGiro().getGiro());
				model.setModulo(cliente.getModulo());
				model.setNombre(cliente.getNombre());
				model.setNroDocumento(cliente.getNroDocumento()+"");
				model.setTipoDocumento(cliente.getTipoDocumento().getTipoDocumento());
				model.setUbigeo(cliente.getUbigeo());
				model.setX(cliente.getX()+"");
				model.setY(cliente.getY()+"");
				model.setDiaVisita(Constans.strDays[cliente.getDiaVisita()]);
				modelos.add(model);
			}
			goodResponse(json);
			json.put("clientes", modelos);
			json.put("materiales", materialService.getByEstado('A'));
			json.put("personal", personal);
			json.put("giros", giroService.getAll());
			json.put("tipoDocumentos", tipoDocumentoservice.getAll());
			json.put("ubigeos", ubigeoService.getAll());
		}else{
			badResponse(json);
		}
		return JSONObject.valueToString(json);
	}
	@RequestMapping(value = "/restPedido", method =RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String savePedido(String detalle, String idCliente){
		double precioTotal = 0.0;
		double pesoTotal= 0.0;
		Map json = new HashMap();
		Cliente cliente =null;
		try{
			cliente = clienteService.findByOne(Integer.parseInt(idCliente));
			Venta venta = new Venta();
			venta.setCliente(cliente);
			venta.setFechaVenta(new Date());
			venta = ventaService.saveVenta(venta);
			System.out.println("Detalle: "+ detalle);
			String[] posiciones = detalle.split(";");
			for (int i = 0; i < posiciones.length; i++) {
				String[] cadena = posiciones[i].split("-");
				String idMat = cadena[0];
				String cant = cadena[1];
				System.out.println("Codigo Material: "+idMat + " Cantidad: "+cant);
				int idMaterial = Integer.parseInt(idMat);
				int cantidad = Integer.parseInt(cant);
				System.out.println("Codigo Material: "+idMaterial + " Cantidad: "+cantidad);
				Material material = materialService.findOne(idMaterial);
				DetVenta detVenta = new DetVenta();
				DetVentaId id = new DetVentaId();
				id.setMaterial(material);
				id.setVenta(venta);
				detVenta.setCantidad(cantidad);
				detVenta.setPk(id);
				double importe = material.getPrecio()*cantidad;
				detVenta.setImporte(importe);
				detVentaService.saveDetVenta(detVenta);
				precioTotal+=importe;
				pesoTotal+=material.getPeso();
			}
			venta.setPrecioTotal(precioTotal);
			venta.setPesoTotal(pesoTotal);
			ventaService.saveVenta(venta);
			json.put("ventas", venta);
			goodResponse(json);
		}catch(NullPointerException|IllegalArgumentException e ){
			System.out.println("Error : "+ e.getMessage());
			badResponse(json);
		}
		return JSONObject.valueToString(json);
	}
	@RequestMapping(value = "/restCliente", method =RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody	
	public String saveCliente(String idPersonal,String diaVisita,
			String direccion,String nroDocumento,String x, String y,
			String giro,String tipoDocumento, String apellido, String nombre,String modulo,
			String ubigeo){
		Cliente cliente=null;
		Personal personal = null;
		TipoDocumento tipoDoc = null;
		Giro ngiro = null;
		Map json = new  HashMap();
		try{
			tipoDoc = tipoDocumentoservice.findOne(tipoDocumento.charAt(0));
			personal = personalService.findOne(Integer.parseInt(idPersonal));
			ngiro = giroService.findOne(giro.charAt(0));
			cliente = new Cliente(direccion, Integer.parseInt(nroDocumento), 'A', new BigDecimal(x), new BigDecimal(y), personal, ngiro, tipoDoc, Integer.parseInt(diaVisita), nombre, apellido, ubigeo, modulo);
			clienteService.saveCliente(cliente);
			json.put("cliente", cliente);
			goodResponse(json);
		}catch(NumberFormatException|NullPointerException e){
			System.out.println("Error : "+ e.getMessage());
			badResponse(json);
		}
		return JSONObject.valueToString(json);
	}
	private int getDay(){
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.DAY_OF_WEEK)-1;
	}
	private void goodResponse(Map json){
		json.put("respuesta", "S");
	}
	private void badResponse(Map json){
		json.put("respuesta", "E");
	}
}