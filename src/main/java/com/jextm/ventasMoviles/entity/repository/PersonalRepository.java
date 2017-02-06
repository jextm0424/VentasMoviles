package com.jextm.ventasMoviles.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jextm.ventasMoviles.entity.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Integer>{

	@Query("select u from Personal u where u.usuario=?1 and u.clave = ?2")
	Personal login(String user, String clave);
	@Query("select u from Personal u where u.nombre=?1")
	List<Personal> findByName(String name);
}
