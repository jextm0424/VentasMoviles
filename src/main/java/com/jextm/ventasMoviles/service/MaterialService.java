package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Material;
import com.jextm.ventasMoviles.entity.repository.MaterialRepository;

@Service
public class MaterialService {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Transactional
	public Material saveMaterial(Material material){
		return materialRepository.saveAndFlush(material);
	}
	@Transactional(readOnly=true)
	public List<Material> getAll(){
		return materialRepository.findAll();
	}
	@Transactional(readOnly=true)
	public List<Material> getByEstado(Character estado)
	{
		return materialRepository.getByEstado(estado);
	}
	@Transactional(readOnly=true)
	public Material findOne(int idMaterial)
	{
		return materialRepository.findOne(idMaterial);
	}
	@Transactional(readOnly=true)
	public List<Material> getByName(String material){
		return materialRepository.getByName("%"+material+"%");
	}

}
