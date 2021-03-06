package es.urjc.code.dad.xkeys_web;

//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	
	private ArrayList<String> clave;
	private String nombre;
	private int precio;
	private String plataforma; 
    private String categoria;
    
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

	protected Producto() {
	}


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
	
	
    
}
