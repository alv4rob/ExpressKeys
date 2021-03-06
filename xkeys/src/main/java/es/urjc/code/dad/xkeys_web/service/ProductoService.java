package es.urjc.code.dad.xkeys_web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productos;
	
	public Collection<Producto> findAll() {
		return productos.findAll();
	}

	public Producto findById(long id) {
		return productos.findById(id);
	}

	public void save(Producto producto) {

		productos.save(producto);
	}

	public void deleteById(long id) {
		this.productos.deleteById(id);
	}
}