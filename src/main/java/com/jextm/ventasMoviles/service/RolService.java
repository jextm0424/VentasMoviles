package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Rol;
import com.jextm.ventasMoviles.entity.repository.RolRepository;

@Service
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	@Transactional
	public Rol saveRol(Rol rol){
		return rolRepository.saveAndFlush(rol);
	}
	
	@Transactional(readOnly=true)
	public List<Rol> getAll(){
		return rolRepository.findAll();
	}

}
