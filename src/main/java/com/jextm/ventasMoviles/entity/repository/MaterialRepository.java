package com.jextm.ventasMoviles.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jextm.ventasMoviles.entity.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{
	
	@Query("select u from Material u where u.estado = ?1")
	List<Material> getByEstado(Character estado);

}
