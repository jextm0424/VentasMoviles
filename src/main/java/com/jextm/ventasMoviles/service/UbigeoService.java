package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Ubigeo;
import com.jextm.ventasMoviles.entity.repository.UbigeoRepository;

@Service
public class UbigeoService {

	@Autowired
	private UbigeoRepository ubigeoRepository;
	@Transactional(readOnly=true)
	public List<Ubigeo> getAll(){
		return ubigeoRepository.findAll();
	}
	@Transactional
	public Ubigeo saveUbigeo(Ubigeo ubigeo){
		return ubigeoRepository.saveAndFlush(ubigeo);
	}
}
