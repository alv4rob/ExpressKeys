package es.urjc.code.dad.xkeys_web.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@SessionScope
@Component
public class Carrito {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Lob
	private ArrayList<Long> carrito;
	private int precioTotal;
	
	
	@OneToOne(mappedBy= "carritoH")
	private Cliente clienteC;
	
	public Carrito() {
		
		carrito = new ArrayList<>();
		precioTotal = 0;
		
	}
	
	public void añadirAlCarrito(Producto producto) {
		carrito.add(producto.getId());	
		precioTotal = precioTotal + producto.getPrecio();
		
	}
	
	public void quitarDelCarrito(Producto producto) {
	    carrito.remove(producto.getId());
	    precioTotal = precioTotal - producto.getPrecio();
	  
	}
	
	public int nCarrito( ) {
	    return carrito.size();
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public ArrayList<Long> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Long> carrito) {
		this.carrito = carrito;
	}

	public boolean esVacio() {
		
		return carrito.size()==0;
	}
	
	public void VaciarCarro() {
		carrito.clear();
		precioTotal= 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getClienteC() {
		return clienteC;
	}

	public void setClienteC(Cliente clienteC) {
		this.clienteC = clienteC;
	}
	
	
	
}