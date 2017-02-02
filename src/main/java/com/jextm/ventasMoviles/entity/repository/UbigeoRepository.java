package com.jextm.ventasMoviles.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jextm.ventasMoviles.entity.Ubigeo;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo, Integer>{

}
