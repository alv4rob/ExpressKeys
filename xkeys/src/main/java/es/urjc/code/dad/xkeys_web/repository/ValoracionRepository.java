package es.urjc.code.dad.xkeys_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.urjc.code.dad.xkeys_web.model.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long>{
	
	Valoracion findById(long id);
	
}