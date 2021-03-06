package es.urjc.code.dad.xkeys_web.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.repository.ClienteRepository;

@Service
public class ClienteService {
	
    @Autowired
    private ClienteRepository clientes;

	public Collection<Cliente> findAll() {
		return clientes.findAll();
	}

	public Cliente findById(long id) {
		return clientes.findById(id);
	}

	public void save(Cliente cliente) {

		clientes.save(cliente);
	}

	public void deleteById(long id) {
		this.clientes.deleteById(id);
	}
}