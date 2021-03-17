package es.urjc.code.dad.xkeys_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Entity
@SessionScope
@Table(name = "Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String contrasena;
	private String correo;
	private ArrayList<String> historial;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Carrito carritoH;
	
	
	protected Cliente() {}
	
	public Cliente (String nombre, String contrasena, String correo) {
		
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.correo=correo;
		historial = new ArrayList<>();
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

	public Carrito getCarritoH() {
		return carritoH;
	}

	public void setCarritoH(Carrito carritoH) {
		this.carritoH = carritoH;
	}
	

	public ArrayList<String> getHistorial() {
		return historial;
	}
	public void setHistorial(ArrayList<String> historial) {
		this.historial = historial;
	}
	
	
	public void añadirAlHistorial(String string) {
		historial.add(string);		
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", correo=" + correo + "]";
	}
	
	public void añadirAlCarrito(Producto producto) {
		carritoH.añadirAlCarrito(producto);
	}
}