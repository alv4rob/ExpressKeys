package es.urjc.code.dad.xkeys_web.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.urjc.code.dad.xkeys_web.model.Carrito;
import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.service.CarritoService;
import es.urjc.code.dad.xkeys_web.service.ClienteService;
import es.urjc.code.dad.xkeys_web.service.ProductoService;

@Controller
public class CarritoController {

	@Autowired
	private ProductoService productoS;
	
	@Autowired
	private CarritoService carritoS;
	
	@Autowired
	private ClienteService clienteS;
	
	@GetMapping("/carrito")
	public String mostrarCarrito(Model model, Authentication auth) {
		
		
		Cliente cliente = clienteS.findByNombre(auth.getName());
		Carrito carrito = carritoS.findById(cliente.getCarritoH().getId());
		
		ArrayList<Producto> listaCarrito = new ArrayList<>();
		
		for (Long x: carrito.getCarrito()) {
			listaCarrito.add(productoS.findById(x));
		}
		model.addAttribute("listaCarrito", listaCarrito);
		model.addAttribute("carrito", carrito);
		model.addAttribute("precioTotal", carrito.getPrecioTotal());

		return "carrito";
	}
	
	
	@GetMapping("/comprar")
	public String comprar(Model model,Authentication auth) {
		
					
		Cliente cliente = clienteS.findByNombre(auth.getName());
		Carrito carrito = carritoS.findById(cliente.getCarritoH().getId());
						    		
		ArrayList<String> recibo = new ArrayList<>();
		for(Long x: carrito.getCarrito()) {
	
			Producto producto = productoS.findById(x);
						
			cliente.añadirAlHistorial(producto.getNombre() + " - " + producto.getPlataforma() + " | " + producto.getPrecio() + "euros | Key: " + producto.getClave().get(0));
			clienteS.save(cliente);
						
			recibo.add(producto.getNombre() + " - " + producto.getPlataforma() + " | " + producto.getPrecio() + "euros | Key: " + producto.comprarClave());
			productoS.save(producto);
		}
		
		carrito.VaciarCarro();
		carritoS.save(carrito);
		model.addAttribute("recibo", recibo);
			
		return "compraFinalizada";		
	}
}
