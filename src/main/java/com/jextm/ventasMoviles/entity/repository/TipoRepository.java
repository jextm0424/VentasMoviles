package com.jextm.ventasMoviles.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jextm.ventasMoviles.entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Character>{
	
}
