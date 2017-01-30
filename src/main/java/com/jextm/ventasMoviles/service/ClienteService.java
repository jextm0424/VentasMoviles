package com.jextm.ventasMoviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.Cliente;
import com.jextm.ventasMoviles.entity.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente saveCliente(Cliente cliente){
		return clienteRepository.saveAndFlush(cliente);
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	@Transactional(readOnly=true)
	public Cliente findByNroDoc(int nroDocumento){
		return clienteRepository.findByNroDoc(nroDocumento);
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> findByName(String nombre){
		return clienteRepository.findByName("%"+nombre+"%");
	}
	
	@Transactional(readOnly=true)
	List<Cliente> findByLastName(String apellido){
		return clienteRepository.findByLastName("%"+apellido+"%");
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> findByEstado(Character estado){
		return clienteRepository.findByEstado(estado);
	}

	@Transactional(readOnly=true)
	public List<Cliente> findByGiro(Character giro){
		return clienteRepository.findByGiro(giro);
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> findByDia(int giro){
		return clienteRepository.findByDia(giro);
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> findByPersonal(int idPersonal){
		return clienteRepository.findByPersonal(idPersonal);
	}
	
	@Transactional(readOnly=true)
	public List<Cliente> findByPersonalDia(int idPersonal,int diaVisita){
		return clienteRepository.findByPersonalDia(idPersonal, diaVisita);
	}

	@Transactional(readOnly=true)
	public Cliente findByOne(int idCliente){
		return clienteRepository.findOne(idCliente);
	}
}
