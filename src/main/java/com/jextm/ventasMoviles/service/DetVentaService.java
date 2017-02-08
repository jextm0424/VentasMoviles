package com.jextm.ventasMoviles.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.DetVenta;
import com.jextm.ventasMoviles.entity.repository.DetVentaRepository;

@Service
public class DetVentaService {
	
	@Autowired
	private DetVentaRepository detVentaRepository;
	
	@Transactional
	public DetVenta saveDetVenta(DetVenta detVenta){
		return detVentaRepository.saveAndFlush(detVenta);
	}

	@Transactional(readOnly=true)
	public List<DetVenta> getAll(){
		return detVentaRepository.findAll();
	}
	@Transactional(readOnly=true)
	public List<DetVenta> findByVenta(int idVenta){
		return detVentaRepository.findByVenta(idVenta);
	}
	@Transactional
	public boolean deleteDetVenta(int idVenta){
		try{
			int venta = detVentaRepository.deleteDetallesVentasById(idVenta);
			return (venta>0) ? true : false;
		}catch(HibernateException e){
			System.out.println("Erro al Eliminar Detalle de venta"+ idVenta);
			return false;
		}
	}
	
	

}
