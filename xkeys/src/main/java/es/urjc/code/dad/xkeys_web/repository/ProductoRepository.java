package es.urjc.code.dad.xkeys_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.urjc.code.dad.xkeys_web.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	Producto findById(long id);
	
	@Query("SELECT id FROM Producto WHERE plataforma='PC'")
	List<Producto> filterByPlataforma(String plafatorma);	

}