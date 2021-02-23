package es.urjc.code.dad.xkeys_web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	@GetMapping("/index")
	public String index(Model model) {
	
		
	    return "index.html";
	}
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam String userName) {
		
		model.addAttribute("nombre", userName);
		
		return "login";
	}
	


}
