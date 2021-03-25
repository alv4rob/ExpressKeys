package es.urjc.code.dad.xkeys_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import es.urjc.code.dad.xkeys_web.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	
	
	Cliente findById(long id);
	
	//@Query("SELECT c FROM Cliente c WHERE c.nombre= ?1")
	Cliente findByNombre(String nombre);
	

}