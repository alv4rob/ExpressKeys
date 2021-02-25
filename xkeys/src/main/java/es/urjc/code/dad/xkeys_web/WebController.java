package es.urjc.code.dad.xkeys_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	

	@PostMapping("/login")
	public String login(Model model, @RequestParam String user, @RequestParam String password) {
		
		model.addAttribute("user", user);
		model.addAttribute("password", password);
		model.addAttribute("productos", productoService.findAll());
		
		return "logged";
	}
	
	//Para el catalogo
	@Autowired
	private ProductoService productoService;

	@GetMapping("/")
	public String mostrarProductos(Model model) {

		model.addAttribute("productos", productoService.findAll());

		return "index";
	}

	@PostMapping("/producto/nuevo")
	public String nuevoProducto(Model model, Producto producto) {

		productoService.save(producto);

		return "productoGuardado";
	}

	@GetMapping("/producto/{id}")
	public String mostrarProducto(Model model, @PathVariable long id) {

		Producto producto = productoService.findById(id);

		model.addAttribute("producto", producto);

		return "mostrarProducto";
	}
	
	@GetMapping("/producto/{id}/eliminar")
	public String eliminarProducto(Model model, @PathVariable long id) {

		productoService.deleteById(id);

		return "productoEliminado";
	}
	
	@Autowired
	private ClienteService clienteService;

	
	@GetMapping("/clientes")
	public String mostrarClientes(Model model) {

		model.addAttribute("clientes", clienteService.findAll());

		return "listaUsuarios";
	}
	
	
	
	@PostMapping("/registrarse")
	public String nuevoUsuario(Model model, Cliente cliente) {

		clienteService.save(cliente);

		return "usuarioRegistrado";
	}
	
	
	
	@GetMapping("/clientes/{id}")
	public String mostrarCliente(Model model, @PathVariable long id) {

		Cliente cliente = clienteService.findById(id);

		model.addAttribute("cliente", cliente);

		return "mostrarCliente";
	}
	
	@GetMapping("/clientes/{id}/eliminar")
	public String eliminarCliente(Model model, @PathVariable long id) {

		clienteService.deleteById(id);

		return "clienteEliminado";
	}
	
	
	
	
	
	
}
