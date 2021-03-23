package es.urjc.code.dad.xkeys_web.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.urjc.code.dad.xkeys_web.model.Carrito;
import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteS;
	
	@PostConstruct
	public void initCliente() {
		
		Cliente cliente =new Cliente("Pepe", "hola1234", "pepe@gmail.com");
		Carrito c1 = new Carrito();
		cliente.setCarritoH(c1);
		clienteS.save(cliente);
		
		Cliente cliente2 =new Cliente("Pepa", "hola1234564", "pepa@gmail.com");
		Carrito c2 = new Carrito();
		cliente2.setCarritoH(c2);
		clienteS.save(cliente2);
		
		Cliente cliente3 =new Cliente("Pepo", "hola123", "pepo@outlook.com");
		Carrito c3 = new Carrito();
		cliente3.setCarritoH(c3);
		clienteS.save(cliente3);
			
	}
	

	@GetMapping("/clientes")
	public String mostrarClientes(Model model) {

		model.addAttribute("clientes", clienteS.findAll());

		return "listaUsuarios";
	}
	
	
	@GetMapping("/registro")
	public String registro() {
		
		return "registrarse";
	}
	
	
	@PostMapping("/registrado")
	public String nuevoUsuario(Model model, Cliente cliente) {

		Carrito carritoDefault = new Carrito();
		cliente.setCarritoH(carritoDefault);
		clienteS.save(cliente);

		return "usuarioRegistrado";
	}
	
	
	@GetMapping("/clientes/{id}")
	public String mostrarCliente(Model model, @PathVariable long id) {

		Cliente cliente = clienteS.findById(id);

		model.addAttribute("cliente", cliente);

		return "mostrarCliente";
	}
	
	
	@GetMapping("/clientes/{id}/eliminar")
	public String eliminarCliente(Model model, @PathVariable long id) {

		clienteS.deleteById(id);

		return "clienteEliminado";
	}	
}
