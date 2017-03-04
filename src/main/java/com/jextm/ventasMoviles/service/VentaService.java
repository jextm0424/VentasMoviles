package com.jextm.ventasMoviles.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Venta;
import com.jextm.ventasMoviles.entity.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;
	
	
	@Transactional 
	public Venta saveVenta(Venta venta){
		return ventaRepository.saveAndFlush(venta);
	}
	
	@Transactional(readOnly=true)
	public List<Venta> getAll(){
		return  ventaRepository.findAll();
	}
	@Transactional(readOnly=true)
	public List<Venta> findByFecha(Date fecha){
		return ventaRepository.findByFecha(fecha);
	}
	@Transactional(readOnly=true)
	public Venta findOne(int idVenta)
	{
		return ventaRepository.findOne(idVenta);
	}
	@Transactional(readOnly=true)
	public List<Venta> findByVendedor(int codVendedor){
		return ventaRepository.findByVendedor(codVendedor);
	}
	@Transactional(readOnly=true)
	public List<Venta> findByCliente(int codCliente){
		return ventaRepository.findByCliente(codCliente);
	}
	@Transactional(readOnly=true)
	public List<Venta> findByModulo(String modulo){
		return ventaRepository.findByModulo("%"+modulo +"%");
	}
	@Transactional(readOnly=true)
	public List<Venta> findByProducto(int idProducto){
		return ventaRepository.findByProducto(idProducto);
	}
	@Transactional(readOnly=true)
	public List<Venta> findByDia(int dia){
		return ventaRepository.findByDia(dia);
	}
	@Transactional(readOnly=true)
	public List<Venta> findByGiro(Character idGiro){
		return ventaRepository.findByGiro(idGiro);
	}
	@Transactional(readOnly=true)
	public List<Venta> findByDistrito(String idDistrito){
		return ventaRepository.findByDistrito(idDistrito);
	}
	@SuppressWarnings("deprecation")
	@Transactional(readOnly=true)
	public List<Venta> findByDayBetween(Date startDay){
		Date endDay = new Date();
		startDay.setHours(0);
		startDay.setMinutes(0);
		startDay.setSeconds(0);
		endDay.setDate(startDay.getDate());
		endDay.setMonth(startDay.getMonth());
		endDay.setYear(startDay.getYear());
		endDay.setHours(23);
		endDay.setMinutes(59);
		endDay.setSeconds(59);
		return ventaRepository.findByDayBetween(startDay, endDay);
	}
}
