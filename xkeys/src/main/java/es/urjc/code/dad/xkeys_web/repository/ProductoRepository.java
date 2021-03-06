package es.urjc.code.dad.xkeys_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.urjc.code.dad.xkeys_web.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	Producto findById(long id);

}