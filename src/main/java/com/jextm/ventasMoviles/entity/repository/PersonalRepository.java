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
	@Query("select u from Personal u where u.nombre like ?1")
	List<Personal> findByName(String name);
	@Query("select u from Personal u where u.usuario like ?1")
	Personal findByUsuario(String usuario);
	@Query("select u from Personal u where u.territorio.idTerritorio = ?1")
	Personal findByTerritorio(int idTerritorio);
	@Query("select u from Personal u where u.rol.idRol = ?1 order by u.apellido")
	List<Personal> findByRol(Character idRol);
	@Query("select u from Personal u")
	Object ajaxFindAll();
}
