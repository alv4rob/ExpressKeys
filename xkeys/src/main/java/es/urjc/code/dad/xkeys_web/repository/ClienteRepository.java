package es.urjc.code.dad.xkeys_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.dad.xkeys_web.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
		
	Cliente findById(long id);
	
	Cliente findByNombre(String nombre);
}