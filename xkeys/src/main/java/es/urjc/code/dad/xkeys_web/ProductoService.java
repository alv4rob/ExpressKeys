package es.urjc.code.dad.xkeys_web;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	
	private ConcurrentMap<Long, Producto> productos = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();

	public ProductoService() {
		save(new Producto("31311313", "Cyberpunk 2077", 70, "PC", "RPG"));
		save(new Producto("14532432", "FIFA 21", 60, "PS4", "Deporte"));
	}

	public Collection<Producto> findAll() {
		return productos.values();
	}

	public Producto findById(long id) {
		return productos.get(id);
	}

	public void save(Producto producto) {

		long id = nextId.getAndIncrement();

		producto.setId(id);

		this.productos.put(id, producto);
	}

	public void deleteById(long id) {
		this.productos.remove(id);
	}

}
