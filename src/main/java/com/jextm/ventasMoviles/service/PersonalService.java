package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Personal;
import com.jextm.ventasMoviles.entity.repository.PersonalRepository;

@Service
public class PersonalService {
	
	@Autowired
	private PersonalRepository personalRepository;
	
	@Transactional
	public Personal savePersonal(Personal personal){
		return personalRepository.saveAndFlush(personal);
	}
	
	@Transactional(readOnly=true)
	public List<Personal> finAll()
	{
		return personalRepository.findAll();
	}
	@Transactional(readOnly=true)
	public Personal login(String user, String clave){
		Personal verficardor = personalRepository.login(user, clave);
		return verficardor;
	}
	@Transactional(readOnly=true)
	public Personal findOne(int codigo){
		return personalRepository.findOne(codigo);
	}
	@Transactional(readOnly=true)
	public List<Personal> findByName(String name){
		return personalRepository.findByName("%"+name+"%");
	}
	@Transactional(readOnly=true)
	public Personal findByUsuario(String usuario){
		return personalRepository.findByUsuario(usuario);
	}
}
