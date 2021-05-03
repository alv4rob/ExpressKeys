package es.urjc.code.dad.xkeys_web.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
	@Lob
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carritoH == null) ? 0 : carritoH.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((historial == null) ? 0 : historial.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		Cliente other = (Cliente) obj;
		if (carritoH == null) {
			if (other.carritoH != null)
				return false;
		} else if (!carritoH.equals(other.carritoH))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (historial == null) {
			if (other.historial != null)
				return false;
		} else if (!historial.equals(other.historial))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (passwordHash == null) {
			if (other.passwordHash != null)
				return false;
		} else if (!passwordHash.equals(other.passwordHash))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}
}