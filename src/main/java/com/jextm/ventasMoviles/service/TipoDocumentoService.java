package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.TipoDocumento;
import com.jextm.ventasMoviles.entity.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	
	@Transactional
	public TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento){
		return tipoDocumentoRepository.saveAndFlush(tipoDocumento);
	}
	
	@Transactional(readOnly=true)
	public List<TipoDocumento> getAll(){
		return tipoDocumentoRepository.findAll();
	}
	@Transactional(readOnly=true)
	public TipoDocumento findOne(Character idTipoDocumento){
		return tipoDocumentoRepository.findOne(idTipoDocumento);
	}

}
