package es.urjc.code.dad.xkeys_web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.code.dad.xkeys_web.model.Carrito;
import es.urjc.code.dad.xkeys_web.repository.CarritoRepository;


@Service
public class CarritoService {
	
	@Autowired
    private CarritoRepository carritos;

	public Collection<Carrito> findAll() {
		return carritos.findAll();
	}

	public Carrito findById(long id) {
		return carritos.findById(id);
	}

	public void save(Carrito carrito) {

		carritos.save(carrito);
	}

	public void deleteById(long id) {
		this.carritos.deleteById(id);
	}
}
