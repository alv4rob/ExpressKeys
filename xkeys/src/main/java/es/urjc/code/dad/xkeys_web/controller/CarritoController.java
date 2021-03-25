package es.urjc.code.dad.xkeys_web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.urjc.code.dad.xkeys_web.model.Carrito;
import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.service.ClienteService;
import es.urjc.code.dad.xkeys_web.service.ProductoService;

@Controller
public class CarritoController {

	@Autowired
	private ProductoService productoS;
	
	@Autowired
	private Carrito carrito;
	
	@Autowired
	private ClienteService clienteS;
	
	@GetMapping("/carrito")
	public String mostrarCarrito(Model model, Authentication auth) {

		Cliente cliente = clienteS.findByNombre(auth.getName());
		model.addAttribute("carrito", cliente.getCarritoH());

		return "carrito";
	}
	
	@GetMapping("/comprar")
	public String comprar(Model model,Authentication auth, HttpServletRequest servlet) {
		//HttpSession sesion = servlet.getSession();
		//Cliente c = (Cliente) sesion.getAttribute("usr");
		Cliente cliente = clienteS.findByNombre(auth.getName());
		ArrayList<String> recibo = new ArrayList<>();
		for(Producto x: cliente.getCarritoH().getCarrito()) {
			
			if (cliente!=null) {
			    cliente.añadirAlHistorial(x.getNombre() + " - " + x.getPlataforma() + " | " + x.getPrecio() + "euros | Key: " + x.getClave().get(0));
			    clienteS.save(cliente);
			}
			
			recibo.add(x.getNombre() + " - " + x.getPlataforma() + " | " + x.getPrecio() + "euros | Key: " + x.comprarClave());
			productoS.save(x);
		}
		
		carrito.VaciarCarro();
		model.addAttribute("recibo", recibo);
		return "compraFinalizada";
	}
}
