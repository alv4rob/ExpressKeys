package es.urjc.code.dad.xkeys_web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.urjc.code.dad.xkeys_web.model.Valoracion;
import es.urjc.code.dad.xkeys_web.repository.ValoracionRepository;

@Service
public class ValoracionService {
	
	@Autowired
	private ValoracionRepository valoraciones;
	
	public Collection<Valoracion> findAll() {
		return valoraciones.findAll();
	}

	public Valoracion findById(long id) {
		return valoraciones.findById(id);
	}

	public void save(Valoracion valoracion) {

		valoraciones.save(valoracion);
	}

	public void deleteById(long id) {
		this.valoraciones.deleteById(id);
	}
}