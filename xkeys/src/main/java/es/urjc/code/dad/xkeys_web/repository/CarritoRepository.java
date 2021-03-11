package es.urjc.code.dad.xkeys_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.dad.xkeys_web.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
	
	Carrito findById(long id);

}