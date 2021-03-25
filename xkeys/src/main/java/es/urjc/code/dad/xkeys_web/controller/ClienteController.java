package es.urjc.code.dad.xkeys_web.controller;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
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
		
		Cliente cliente = new Cliente("Pepe", "Hey12345", "pepe@gmail.com", "ROLE_USER");
		Carrito c1 = new Carrito();
		cliente.setCarritoH(c1);
		clienteS.save(cliente);
		
		Cliente cliente2 =new Cliente("Pepa", "hola1234564", "pepa@gmail.com", "ROLE_USER");
		Carrito c2 = new Carrito();
		cliente2.setCarritoH(c2);
		clienteS.save(cliente2);
		
		Cliente cliente3 =new Cliente("Pepo", "hola123", "pepo@outlook.com", "ROLE_USER", "ROLE_ADMIN");
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
	public String registro(Model model,HttpServletRequest request) {
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 model.addAttribute("token", token.getToken());
		return "registrarse";
	}
	
	
	@PostMapping("/registrado")
	public String nuevoUsuario(Model model,HttpServletRequest request,String nombre, String contrasena, String correo, String... roles) {
		Cliente cliente = new Cliente(nombre, contrasena, correo,  roles);
		Carrito carritoDefault = new Carrito();
		cliente.setCarritoH(carritoDefault);
		clienteS.save(cliente);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 model.addAttribute("token", token.getToken());
		

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
