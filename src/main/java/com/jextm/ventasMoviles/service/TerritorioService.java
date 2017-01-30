package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Territorio;
import com.jextm.ventasMoviles.entity.repository.TerritorioRepository;

@Service
public class TerritorioService {
	
	@Autowired
	private TerritorioRepository territorioRepository;
	
	@Transactional
	public Territorio saveTerritorio(Territorio  territorio){
		return territorioRepository.saveAndFlush(territorio);
	}
	
	@Transactional(readOnly=true)
	public List<Territorio> getAll(){
		return territorioRepository.findAll();
	}

}
