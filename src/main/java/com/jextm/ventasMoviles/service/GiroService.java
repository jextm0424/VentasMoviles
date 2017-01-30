package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Giro;
import com.jextm.ventasMoviles.entity.repository.GiroRepository;

@Service
public class GiroService {
	
	@Autowired
	private GiroRepository giroRepository;
	
	@Transactional
	public Giro saveGiro(Giro giro)
	{
		return giroRepository.saveAndFlush(giro);
	}
	
	@Transactional( readOnly = true)
	public List<Giro> getAll(){
		return giroRepository.findAll();
	}
	@Transactional(readOnly = true)
	public Giro findOne(Character idGiro){
		return giroRepository.findOne(idGiro);
	}

}
