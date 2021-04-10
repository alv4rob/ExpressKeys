package es.urjc.code.dad.xkeys_web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.service.ClienteService;
import es.urjc.code.dad.xkeys_web.service.ProductoService;


@Controller
public class WebController {
	

	@Autowired
	private ProductoService productoS;
	
	@Autowired
	private ClienteService clienteS;

	
	@GetMapping("/")
	public String mostrarProductos(Model model, @RequestParam(defaultValue = "false") String filtro, @RequestParam(defaultValue = "false") String busqueda,HttpServletRequest request) {	
		
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

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 model.addAttribute("token", token.getToken());
		return "index";
	}
	

	@GetMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 model.addAttribute("token", token.getToken());
		
		return "login";
	}
	
	
	
    @GetMapping("/loginerror")
    public String loginerror() {
    	return "loginerror";
    }

    @GetMapping("/home")
    public String home(Model model, Authentication auth, HttpServletRequest request, @RequestParam(defaultValue = "false") String filtro, @RequestParam(defaultValue = "false") String busqueda) {
    	
    	
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	model.addAttribute("user", request.isUserInRole("USER"));
    	
    	Cliente cliente = clienteS.findByNombre(auth.getName());
   
    	model.addAttribute("usuario", cliente.getNombre());
    	
    	model.addAttribute("n", cliente.getCarritoH().nCarrito());
    	
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
		
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		 
        return "home";
    }
    
    @GetMapping("/admin")
    public String admin(Model model,HttpServletRequest request) {
    	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
    	return "admin";
    }	
}