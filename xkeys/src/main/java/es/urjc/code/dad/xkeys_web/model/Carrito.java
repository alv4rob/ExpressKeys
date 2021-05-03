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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrito == null) ? 0 : carrito.hashCode());
		result = prime * result + ((clienteC == null) ? 0 : clienteC.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + precioTotal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		if (carrito == null) {
			if (other.carrito != null)
				return false;
		} else if (!carrito.equals(other.carrito))
			return false;
		if (clienteC == null) {
			if (other.clienteC != null)
				return false;
		} else if (!clienteC.equals(other.clienteC))
			return false;
		if (id != other.id)
			return false;
		if (precioTotal != other.precioTotal)
			return false;
		return true;
	}			
}