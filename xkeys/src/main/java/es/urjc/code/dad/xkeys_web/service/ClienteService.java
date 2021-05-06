package es.urjc.code.dad.xkeys_web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.repository.ClienteRepository;

@CacheConfig(cacheNames="clientes")
@Service
public class ClienteService {
	
    @Autowired
    private ClienteRepository clientes;

    @Cacheable
	public Collection<Cliente> findAll() {
    	try {
			Thread.sleep (6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return clientes.findAll();
	}

	public Cliente findById(long id) {
		return clientes.findById(id);
	}
	
	public Cliente findByNombre(String nombre) {
		return clientes.findByNombre(nombre);
	}

	@CacheEvict(allEntries=true)
	public void save(Cliente cliente) {

		clientes.save(cliente);
	}

	@CacheEvict(allEntries=true)
	public void deleteById(long id) {
		this.clientes.deleteById(id);
	}
}