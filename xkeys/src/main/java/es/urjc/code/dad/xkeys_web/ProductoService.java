package es.urjc.code.dad.xkeys_web;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	
	private ConcurrentMap<Long, Producto> productos = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();

	/*public ProductoService() {
		save(new Producto(new ArrayList<>(Arrays.asList("cyberps41", "cyberps42", "cyberps43")), new ArrayList<>(Arrays.asList("cyberxbox1", "cyberxbox2", "cyberxbox3")), new ArrayList<>(Arrays.asList("cyberpc1", "cyberpc2", "cyberpc3")), "Cyberpunk 2077", 70, "PC/PS4/XBOXONE", "RPG"));
		save(new Producto(new ArrayList<>(Arrays.asList("fifaps41", "fifaps42", "fifaps413")), new ArrayList<>(Arrays.asList("fifaps41", "fifaps42", "fifaps413")), new ArrayList<>(Arrays.asList("fifaps41", "fifaps42", "fifaps413")), "FIFA 21", 60, "PC/PS4/XBOXONE", "Deporte"));
		save(new Producto(new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), new ArrayList<>(Arrays.asList("minecraftps41", "minecraftps42", "minecraftps413")), "Minecraft", 20, "PC/PS4/XBOXONE/Switch", "Sandbox"));
	}*/

	public Collection<Producto> findAll() {
		return productos.values();
	}

	public Producto findById(long id) {
		return productos.get(id);
	}

	public void save(Producto producto) {

		long id = nextId.getAndIncrement();

		producto.setId(id);

		this.productos.put(id, producto);
	}

	public void deleteById(long id) {
		this.productos.remove(id);
	}

}
