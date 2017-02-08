package com.jextm.ventasMoviles.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jextm.ventasMoviles.entity.DetVenta;


@Repository
public interface DetVentaRepository extends JpaRepository<DetVenta, Integer>{
	
	@Query("select u from DetVenta u where u.pk.venta.idVenta=?1")
	List<DetVenta> findByVenta(int idVenta);

    @Modifying
    @Transactional
    @Query("delete from DetVenta u where u.pk.venta.idVenta = ?1")
	int deleteDetallesVentasById(int idVenta);

}
