package es.urjc.code.dad.xkeys_web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private Carrito carrito;
	

	
	
	@GetMapping("/")
	public String mostrarProductos(Model model, HttpSession sesion) {

		model.addAttribute("bienvenida", sesion.isNew());
		
		model.addAttribute("n", carrito.nCarrito());
		
		model.addAttribute("productos", productoService.findAll());

		return "index";
	}
	
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String user, @RequestParam String password) {
		
		model.addAttribute("user", user);
		model.addAttribute("password", password);
		model.addAttribute("productos", productoService.findAll());
		
		return "logged";
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
	
	@GetMapping("/producto/{id}/anadido")
	public String añadirCarrito(Model model, @PathVariable long id) {
  
		Producto producto = productoService.findById(id);
		carrito.añadirAlCarrito(producto);

		return "anadidoCarrito";
	}
	


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
	
	
	@GetMapping("/carrito")
	public String mostrarCarrito(Model model) {

		//model.addAttribute("precioTotal", carrito.getPrecioTotal());
		model.addAttribute("carrito", carrito);

		return "carrito";
	}
	
	/*@GetMapping("/comprar")
	public String comprar(Model model) {

		model.addAttribute("carrito", carrito.getCarrito());

		return "carrito";
	}*/
	
	
	
}
