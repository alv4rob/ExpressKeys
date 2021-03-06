package es.urjc.code.dad.xkeys_web;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrito {
	
	private ArrayList<Producto> carrito;
	private int precioTotal;
	
	public Carrito() {
		
		carrito = new ArrayList<>();
		precioTotal = 0;
		
	}
	
	public void añadirAlCarrito(Producto producto) {
		carrito.add(producto);	
		precioTotal = precioTotal + producto.getPrecio();
		
	}
	
	public void quitarDelCarrito(Producto producto) {
	    carrito.remove(producto);
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

	public ArrayList<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Producto> carrito) {
		this.carrito = carrito;
	}

	public boolean esVacio() {
		
		return carrito.size()==0;
	}
	
	public void VaciarCarro() {
		carrito.clear();
		precioTotal= 0;
	}

}
