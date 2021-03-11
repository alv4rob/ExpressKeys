package es.urjc.code.dad.xkeys_web.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.code.dad.xkeys_web.model.Carrito;
import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.service.ClienteService;
import es.urjc.code.dad.xkeys_web.service.ProductoService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteS;
	
	@Autowired
	private ProductoService productoS;
	
	@Autowired
	private Carrito carrito;
	
	@PostConstruct
	public void initCliente() {
		
		clienteS.save(new Cliente("Pepe", "hola1234", "pepe@gmail.com"));
		clienteS.save(new Cliente("Pepa", "hola1234564", "pepa@gmail.com"));
		clienteS.save(new Cliente("Pepo", "hola123", "pepo@outlook.com"));
		
	}

	@GetMapping("/clientes")
	public String mostrarClientes(Model model) {

		model.addAttribute("clientes", clienteS.findAll());

		return "listaUsuarios";
	}
	
	@PostMapping("/registrarse")
	public String nuevoUsuario(Model model, Cliente cliente) {

		clienteS.save(cliente);

		return "usuarioRegistrado";
	}
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String user, @RequestParam String password, HttpSession sesion) {
		
		model.addAttribute("user", user);
		model.addAttribute("password", password);
		model.addAttribute("n", carrito.nCarrito());
		model.addAttribute("productos", productoS.findAll());
		
		return "logged";
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
