package es.urjc.code.dad.xkeys_web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Lob
	private ArrayList<String> clave;
	private String nombre;
	private int precio;
	private String plataforma; 
    private String categoria;
    
    @JsonIgnore
    @OneToMany(mappedBy = "productoH", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Valoracion> valoracion = new ArrayList<>();

	public Producto(ArrayList<String> clave, String nombre,
			int precio, String plataforma, String categoria) {
		this.clave = clave;
		this.nombre = nombre;
		this.precio = precio;
		this.plataforma = plataforma;
		this.categoria = categoria;
	}

	protected Producto() {}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
		
	public String comprarClave() {
		String e = clave.get(0);
		clave.remove(0);
		return e;
	}

	public ArrayList<String> getClave() {
		return clave;
	}

	public void setClave(ArrayList<String> clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public List<Valoracion> getValoracion() {
		return valoracion;
	}

	public void setValoracion(List<Valoracion> valoracion) {
		this.valoracion = valoracion;
	}
	
	public void anadirValoracion(Valoracion valoraciones) {
        valoracion.add(valoraciones);
        valoraciones.setProductoH(this);
    }
		
	@Override
	public String toString() {
		return "Producto [id=" + id + ", Clave=" + clave + ", nombre=" + nombre
				+ ", precio=" + precio + ", plataforma=" + plataforma + ", categoria=" + categoria + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		result = prime * result + precio;
		result = prime * result + ((valoracion == null) ? 0 : valoracion.hashCode());
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
		Producto other = (Producto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		if (precio != other.precio)
			return false;
		if (valoracion == null) {
			if (other.valoracion != null)
				return false;
		} else if (!valoracion.equals(other.valoracion))
			return false;
		return true;
	}
}