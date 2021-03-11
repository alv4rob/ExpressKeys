package es.urjc.code.dad.xkeys_web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import es.urjc.code.dad.xkeys_web.model.Producto;
import es.urjc.code.dad.xkeys_web.model.Valoracion;
import es.urjc.code.dad.xkeys_web.service.ProductoService;
import es.urjc.code.dad.xkeys_web.service.ValoracionService;

@Controller
public class ValoracionController {
	
	@Autowired
	private ValoracionService valoracionS;
	

	@Autowired
	private ProductoService productoS;
	
	
	
	@GetMapping("/producto/{id}/introducirValoracion")
	public String guardarAnuncio(Model model,@PathVariable long id) {
		
		Producto producto = productoS.findById(id);
		model.addAttribute("producto", producto);
		

		return "introducirValoracion";
	}
	
	
	@PostMapping("/producto/{id}/ValoracionEnviada")
	public  String anadirValoracion(Model model, Valoracion valoracion,@PathVariable long id) {
		
		
		Producto producto = productoS.findById(id);
		model.addAttribute("producto", producto);
		
		valoracion.setProductoH(producto);
		
		valoracionS.save(valoracion);
		
		
		
		return "ValoracionEnviada";
	}
}
