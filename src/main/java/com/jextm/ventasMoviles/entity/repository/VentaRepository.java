package com.jextm.ventasMoviles.entity.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jextm.ventasMoviles.entity.Venta;

import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

	@Query("select u from Venta u where u.fechaVenta = ?1")
	List<Venta> findByFecha(Date fecha);
}
