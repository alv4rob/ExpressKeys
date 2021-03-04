package es.urjc.code.dad.xkeys_web;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	Producto findById(long id);

}
