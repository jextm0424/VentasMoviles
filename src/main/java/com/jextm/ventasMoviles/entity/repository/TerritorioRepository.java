package com.jextm.ventasMoviles.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jextm.ventasMoviles.entity.Territorio;

@Repository
public interface TerritorioRepository extends JpaRepository<Territorio, Integer>{

}
