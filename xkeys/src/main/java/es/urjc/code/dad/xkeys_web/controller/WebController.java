package es.urjc.code.dad.xkeys_web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.code.dad.xkeys_web.model.Carrito;
import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.service.ClienteService;
import es.urjc.code.dad.xkeys_web.service.ProductoService;


@Controller
public class WebController {
	

	@Autowired
	private ProductoService productoS;
	
	@Autowired
	private ClienteService clienteS;
	
	@Autowired
	private Carrito carrito;
	
	
	
	
	@GetMapping("/")
	public String mostrarProductos(Model model, HttpSession sesion, @RequestParam(defaultValue = "false") String filtro, @RequestParam(defaultValue = "false") String busqueda) {
	
		model.addAttribute("bienvenida", sesion.isNew());
	
		model.addAttribute("n", carrito.nCarrito());	
		
		model.addAttribute("productos", productoS.findAll());
		
		if (filtro.equals("PC")||filtro.equals("PS4")||filtro.equals("XBOX ONE")) {
		    model.addAttribute("productos", productoS.filterByPlataforma(filtro));
		}
		
		if (filtro.equals("0")||filtro.equals("34")||filtro.equals("68")) {
		    model.addAttribute("productos", productoS.filterByPrecio(Integer.parseInt(filtro), Integer.parseInt(filtro)+33));
		}
		
		if (filtro.equals("Accion")||filtro.equals("Plataformas")||filtro.equals("Terror")||filtro.equals("Deporte")||filtro.equals("Simulador")) {
	    model.addAttribute("productos", productoS.filterByCategoria(filtro));
	    }
		
		if (!busqueda.equals("false")) {
		    model.addAttribute("productos", productoS.filterByBusqueda(busqueda));
		}

		return "index";
	}
	

	@PostMapping("/login")
	public String login(Model model, @RequestParam String user, HttpServletRequest servlet) {
				
		Cliente c = clienteS.findByNombre(user);
		
		HttpSession sesion = servlet.getSession();
		sesion.setAttribute("usr", c);
		
		model.addAttribute("user", c.getNombre());
		model.addAttribute("n", carrito.nCarrito());
		model.addAttribute("productos", productoS.findAll());
		
		return "logged";
	}
	
	
}