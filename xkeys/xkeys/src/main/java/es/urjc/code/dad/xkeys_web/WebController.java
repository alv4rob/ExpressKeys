package es.urjc.code.dad.xkeys_web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	@GetMapping("/principal")
	public String principal() {
		return "hola.html";
		
	}

}
