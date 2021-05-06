package es.urjc.code.dad.xkeys_web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.repository.ProductoRepository;

@CacheConfig(cacheNames="productos")
@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productos;
	
	@Cacheable
	public Collection<Producto> findAll() {
		try {
			Thread.sleep (6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productos.findAll();
	}
	
	@Cacheable
	public Collection<Producto> filterByPlataforma(String plataforma) {
		try {
			Thread.sleep (6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productos.filterByPlataforma(plataforma);
	}
	
	@Cacheable
	public Collection<Producto> filterByPrecio(int precio, int precio2) {
		try {
			Thread.sleep (6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productos.filterByPrecio(precio, precio2);
	}
	
	@Cacheable
	public Collection<Producto> filterByCategoria(String categoria) {
		try {
			Thread.sleep (6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productos.filterByCategoria(categoria);
	}
	
	public Collection<Producto> filterByBusqueda(String busqueda) {
		return productos.filterByBusqueda(busqueda);
	}

	public Producto findById(long id) {
		return productos.findById(id);
	}

	@CacheEvict(allEntries=true)
	public void save(Producto producto) {

		productos.save(producto);
	}

	@CacheEvict(allEntries=true)
	public void deleteById(long id) {
		this.productos.deleteById(id);
	}
}