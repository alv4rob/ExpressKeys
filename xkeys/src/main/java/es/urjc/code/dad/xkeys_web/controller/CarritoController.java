package es.urjc.code.dad.xkeys_web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.urjc.code.dad.xkeys_web.model.Carrito;
import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.service.ProductoService;

@Controller
public class CarritoController {

	@Autowired
	private ProductoService productoS;
	
	@Autowired
	private Carrito carrito;
	
	@GetMapping("/carrito")
	public String mostrarCarrito(Model model) {

		model.addAttribute("carrito", carrito);

		return "carrito";
	}
	
	@GetMapping("/comprar")
	public String comprar(Model model) {

		ArrayList<String> recibo = new ArrayList<>();
		for(Producto x: carrito.getCarrito()) {
			recibo.add(x.getNombre() + " - " + x.getPlataforma() + " | " + x.getPrecio() + "euros | Key: " + x.comprarClave());
			productoS.save(x);
		}
		
		carrito.VaciarCarro();
		model.addAttribute("recibo", recibo);

		return "compraFinalizada";
	}
}
