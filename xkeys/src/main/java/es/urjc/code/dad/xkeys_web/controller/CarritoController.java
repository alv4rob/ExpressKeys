package es.urjc.code.dad.xkeys_web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String mostrarCarrito(Model model) {

		model.addAttribute("carrito", carrito);

		return "carrito";
	}
	
	@GetMapping("/comprar")
	public String comprar(Model model, HttpServletRequest servlet) {
		HttpSession sesion = servlet.getSession();
		Cliente c = (Cliente) sesion.getAttribute("usr");
		ArrayList<String> recibo = new ArrayList<>();
		for(Producto x: carrito.getCarrito()) {
			
			if (c!=null) {
			    c.añadirAlHistorial(x.getNombre() + " - " + x.getPlataforma() + " | " + x.getPrecio() + "euros | Key: " + x.getClave().get(0));
			    clienteS.save(c);
			}
			
			recibo.add(x.getNombre() + " - " + x.getPlataforma() + " | " + x.getPrecio() + "euros | Key: " + x.comprarClave());
			productoS.save(x);
		}
		
		carrito.VaciarCarro();
		model.addAttribute("recibo", recibo);
		return "compraFinalizada";
	}
}
