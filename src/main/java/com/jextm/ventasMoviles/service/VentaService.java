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
}
