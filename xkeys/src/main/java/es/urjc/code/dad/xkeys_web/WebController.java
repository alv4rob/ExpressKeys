package es.urjc.code.dad.xkeys_web;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class WebController {
	
	
	@Autowired
	private ValoracionRepository valoracionR;
	
	@Autowired
	private ClienteRepository clienteR;
	
	@Autowired
	private ProductoRepository productoR;
	
	@Autowired
	private Carrito carrito;
	
	@PostConstruct
	public void initC() {
		clienteR.save(new Cliente("Pepe", "hola1234", "pepe@gmail.com"));
		clienteR.save(new Cliente("Pepa", "hola1234564", "pepaa@gmail.com"));
	}
	
	/*@PostConstruct
	public void initP() {
		productoR.save(new Producto(new ArrayList<>(Arrays.asList("cyberps41", "cyberps42", "cyberps43")), new ArrayList<>(Arrays.asList("cyberxbox1", "cyberxbox2", "cyberxbox3")), new ArrayList<>(Arrays.asList("cyberpc1", "cyberpc2", "cyberpc3")), "Cyberpunk 2077", 70, "PC/PS4/XBOXONE", "RPG"));
		productoR.save(new Producto(new ArrayList<>(Arrays.asList("fifaps41", "fifaps42", "fifaps413")), new ArrayList<>(Arrays.asList("fifaps41", "fifaps42", "fifaps413")), new ArrayList<>(Arrays.asList("fifaps41", "fifaps42", "fifaps413")), "FIFA 21", 60, "PC/PS4/XBOXONE", "Deporte"));
		productoR.save(new Producto(new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), "Minecraft", 20, "PC/PS4/XBOXONE/Switch", "Sandbox"));
	
	}
	@PostConstruct
	public void initV() {
		valoracionR.save(new Valoracion("Pepe", "Contento con la compra"));
	}*/
	
	@PostConstruct
	public void initPV() {
		Producto producto= new Producto(new ArrayList<>(Arrays.asList("cyberps41", "cyberps42", "cyberps43")), "Cyberpunk 2077", 70, "PC/PS4/XBOXONE", "RPG");
		Producto producto2= new Producto(new ArrayList<>(Arrays.asList("fifaps41", "fifaps42", "fifaps413")), "FIFA 21", 60, "PC/PS4/XBOXONE", "Deporte");
		//Producto producto3 =new Producto(new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), "Minecraft", 20, "PC/PS4/XBOXONE/Switch", "Sandbox");
		
		productoR.save(producto);
		productoR.save(producto2);
		//productoR.save(producto3);
		
		Valoracion v1 = new Valoracion("Pepe","Muy contento con la compra");
		Valoracion v3 = new Valoracion("Pepe","Muy contento con la compra");
		Valoracion v2 = new Valoracion("Pepa","Muy disgustada con la compra");
		
		v1.setProductoH(producto);
		v2.setProductoH(producto);
		
		v3.setProductoH(producto2);
		
		valoracionR.save(v1);
		valoracionR.save(v2);
		valoracionR.save(v3);
	}
	
	@GetMapping("/")
	public String mostrarProductos(Model model, HttpSession sesion) {

		
		model.addAttribute("bienvenida", sesion.isNew());
		model.addAttribute("n", carrito.nCarrito());		
		model.addAttribute("productos", productoR.findAll());

		return "index";
	}
	
	
	@PostMapping("/login")
	public String login(Model model, @RequestParam String user, @RequestParam String password, HttpSession sesion) {
		
		model.addAttribute("user", user);
		model.addAttribute("password", password);
		model.addAttribute("n", carrito.nCarrito());
		model.addAttribute("productos", productoR.findAll());
		
		return "logged";
	}
	


	@GetMapping("/producto/{id}")
	public String mostrarProducto(Model model, @PathVariable long id) {

		Producto producto = productoR.findById(id);
		model.addAttribute("producto", producto);

		return "mostrarProducto";
	}
	
	@GetMapping("/producto/{id}/eliminar")
	public String eliminarProducto(Model model, @PathVariable long id) {

		productoR.deleteById(id);

		return "productoEliminado";
	}
	
	@GetMapping("/producto/{id}/anadido")
	public String añadirCarrito(Model model, @PathVariable long id) {
  
		Producto producto = productoR.findById(id);
		/*if(return noAnadidoCarrito) {
			
		}*/
		carrito.añadirAlCarrito(producto);

		return "anadidoCarrito";
	}
	


	@GetMapping("/clientes")
	public String mostrarClientes(Model model) {

		model.addAttribute("clientes", clienteR.findAll());

		return "listaUsuarios";
	}
	
	
	@PostMapping("/registrarse")
	public String nuevoUsuario(Model model, Cliente cliente) {

		clienteR.save(cliente);

		return "usuarioRegistrado";
	}
	
	
	@GetMapping("/clientes/{id}")
	public String mostrarCliente(Model model, @PathVariable long id) {

		Cliente cliente = clienteR.findById(id);

		model.addAttribute("cliente", cliente);

		return "mostrarCliente";
	}
	
	@GetMapping("/clientes/{id}/eliminar")
	public String eliminarCliente(Model model, @PathVariable long id) {

		clienteR.deleteById(id);

		return "clienteEliminado";
	}
	
	
	@GetMapping("/carrito")
	public String mostrarCarrito(Model model) {

		//model.addAttribute("precioTotal", carrito.getPrecioTotal());
		model.addAttribute("carrito", carrito);

		return "carrito";
	}
	

	@GetMapping("/producto/{id}/introducirValoracion")
	public String guardarAnuncio(Model model,@PathVariable long id) {
		
		Producto producto = productoR.findById(id);
		model.addAttribute("producto", producto);
		

		return "introducirValoracion";
	}
	
	@PostMapping("/producto/{id}/ValoracionEnviada")
	public  String anadirValoracion(Model model, Valoracion valoracion,@PathVariable long id) {
		
		
		Producto producto = productoR.findById(id);
		model.addAttribute("producto", producto);
		
		valoracion.setProductoH(producto);
		
		valoracionR.save(valoracion);
		
		
		
		return "ValoracionEnviada";
	
	}
	
	@PostMapping("/producto/nuevo")
	public String nuevoProducto(Model model, Producto producto) {

		productoR.save(producto);
		return "productoGuardado";
	}
	
	@GetMapping("/comprar")
	public String comprar(Model model) {

		String claveComprada = "/";
		for(Producto x: carrito.getCarrito()) {
			claveComprada = claveComprada + x.comprarClave() + "/";
			productoR.save(x);
		}
		
		carrito.VaciarCarro();
		model.addAttribute("claves", claveComprada);

		return "compraFinalizada";
	}
	
}
