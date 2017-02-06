package com.jextm.ventasMoviles.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jextm.ventasMoviles.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query("select u from Cliente u where u.nroDocumento = ?1")
	Cliente findByNroDoc(int nroDocumento);
	
	@Query("select u from Cliente u where u.nombre like ?1")
	List<Cliente> findByName(String nombre);
	
	@Query("select u from Cliente u where u.apellido like ?1")
	List<Cliente> findByLastName(String apellido);
	
	@Query("select u from Cliente u where u.estado = ?1")
	List<Cliente> findByEstado(Character estado);

	@Query("select u from Cliente u where u.giro.idGiro = ?1")
	List<Cliente> findByGiro(Character giro);
	
	@Query("select u from Cliente u where u.diaVisita = ?1")
	List<Cliente> findByDia(int giro);
	
	@Query("select u from Cliente u where u.personal.idPersonal = ?1")
	List<Cliente> findByPersonal(int idPersonal);
	
	@Query("select u from Cliente u where u.personal.idPersonal = ?1 and u.diaVisita = ?2")
	List<Cliente> findByPersonalDia(int idPersonal,int diaVisita);

}
