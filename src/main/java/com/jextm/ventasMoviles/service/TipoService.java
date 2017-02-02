package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Tipo;
import com.jextm.ventasMoviles.entity.repository.TipoRepository;

@Service
public class TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Transactional(readOnly=true)
	public List<Tipo> getAll(){
		return tipoRepository.findAll();
	}
	@Transactional
	public Tipo saveTipo(Tipo tipo){
		return tipoRepository.saveAndFlush(tipo);
	}

}
