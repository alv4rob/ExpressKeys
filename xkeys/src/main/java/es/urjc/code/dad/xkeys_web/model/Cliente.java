package es.urjc.code.dad.xkeys_web.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.OneToOne;

@Entity
@SessionScope
@Table(name = "Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String passwordHash;
	private String correo;
	private ArrayList<String> historial;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Carrito carritoH;
	
	
	protected Cliente() {}
	
	public Cliente (String nombre, String contrasena, String correo, String... roles) {
		
		this.nombre = nombre;
		this.passwordHash = new BCryptPasswordEncoder().encode(contrasena);
		this.correo=correo;
		historial = new ArrayList<>();
		this.roles = new ArrayList<>(Arrays.asList(roles));
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
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
		return "Cliente [id=" + id + ", nombre=" + nombre + ", contrasena=" + passwordHash + ", correo=" + correo + "]";
	}
	
	public void añadirAlCarrito(Producto producto) {
		carritoH.añadirAlCarrito(producto);
	}
}