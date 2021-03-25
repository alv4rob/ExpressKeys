package es.urjc.code.dad.xkeys_web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.urjc.code.dad.xkeys_web.model.Cliente;
import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.model.Valoracion;
import es.urjc.code.dad.xkeys_web.service.ClienteService;
import es.urjc.code.dad.xkeys_web.service.ProductoService;
import es.urjc.code.dad.xkeys_web.service.ValoracionService;

@Controller
public class ValoracionController {
	
	@Autowired
	private ValoracionService valoracionS;
	
	@Autowired
	private ClienteService clienteS;

	@Autowired
	private ProductoService productoS;
	
	
	
	@GetMapping("/producto/{id}/introducirValoracion")
	public String guardarAnuncio(Model model,@PathVariable long id,HttpServletRequest request) {
		
		Producto producto = productoS.findById(id);
		model.addAttribute("producto", producto);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		 model.addAttribute("token", token.getToken());

		return "introducirValoracion";
	}
	
	
	@PostMapping("/producto/{id}/ValoracionEnviada")
	public  String anadirValoracion(Model model,Authentication auth, String comentario, @PathVariable long id) {
		
		Cliente cliente = clienteS.findByNombre(auth.getName());
		Valoracion valoracion = new Valoracion(cliente.getNombre() , comentario);
		Producto producto = productoS.findById(id);
		model.addAttribute("producto", producto);
		
		valoracion.setProductoH(producto);
		
		valoracionS.save(valoracion);
		
		
		
		return "ValoracionEnviada";
	}
}
