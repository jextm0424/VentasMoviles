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
	
	@Query("select u from Venta u where u.cliente.personal.idPersonal = ?1")
	List<Venta> findByVendedor(int codVendedor);
	
	@Query("select u from Venta u where u.cliente.idCliente = ?1")
	List<Venta> findByCliente(int codCliente);
	
	@Query("select u from Venta u where u.cliente.modulo like ?1")
	List<Venta> findByModulo(String modulo);
	
	@Query("select u.pk.venta from DetVenta u where u.pk.material.idMaterial = ?1")
	List<Venta> findByProducto(int idProducto);
	
	@Query("select u from Venta u where u.cliente.diaVisita = ?1")
	List<Venta> findByDia(int dia);
	
	@Query("select u from Venta u where u.cliente.giro.idGiro = ?1")
	List<Venta> findByGiro(Character idGiro);
	
	@Query("select u from Venta u where u.cliente.ubigeo like ?1")
	List<Venta> findByDistrito(String idDistrito);
	
	@Query("select u from Venta u where u.fechaVenta between ?1 and ?2")
	List<Venta> findByDayBetween(Date startDay,Date endDay);
	
}
