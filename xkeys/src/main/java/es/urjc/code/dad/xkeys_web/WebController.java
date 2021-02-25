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
	
//	@PostMapping("/index")
//	public String index() {
//	
//		
//	    return "index";
//  	}
//	
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
	public String showPosts(Model model) {

		model.addAttribute("productos", productoService.findAll());

		return "index";
	}

	@PostMapping("/producto/nuevo")
	public String newPost(Model model, Producto producto) {

		productoService.save(producto);

		return "guardarProducto";
	}

	@GetMapping("/producto/{id}")
	public String showPost(Model model, @PathVariable long id) {

		Producto producto = productoService.findById(id);

		model.addAttribute("producto", producto);

		return "mostrarProducto";
	}
	
	@GetMapping("/producto/{id}/eliminar")
	public String deletePost(Model model, @PathVariable long id) {

		productoService.deleteById(id);

		return "eliminarProducto";
	}
	
	@Autowired
	private ClienteService clienteService;

	
	@PostMapping("/registrarse")
	public String nuevoUsuario(Model model, Cliente cliente) {

		clienteService.save(cliente);

		return "usuarioRegistrado";
	}
	
}
