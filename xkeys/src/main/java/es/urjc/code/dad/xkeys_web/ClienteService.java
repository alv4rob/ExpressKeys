package es.urjc.code.dad.xkeys_web;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	
	private ConcurrentMap<Long, Cliente> clientes = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();

	/*public ClienteService() {
		save(new Cliente("Pepe", "hola1234", "pepe@gmail.com"));
		save(new Cliente("Pepa", "hola1234564", "pepaa@gmail.com"));
	}*/

	public Collection<Cliente> findAll() {
		return clientes.values();
	}

	public Cliente findById(long id) {
		return clientes.get(id);
	}

	public void save(Cliente cliente) {

		long id = nextId.getAndIncrement();

		cliente.setId(id);

		this.clientes.put(id, cliente);
	}

	public void deleteById(long id) {
		this.clientes.remove(id);
	}

}