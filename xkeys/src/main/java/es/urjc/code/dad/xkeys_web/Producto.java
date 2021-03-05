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
	
	
	
	private ArrayList<String> ps4;
	private ArrayList<String> xboxone;
	private ArrayList<String> pc;
	private String nombre;
	private int precio;
	private String plataforma; 
    private String categoria;
    
    @OneToMany(mappedBy = "productoH", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Valoracion> valoracion = new ArrayList<>();

	public Producto(ArrayList<String> ps4, ArrayList<String> xboxone, ArrayList<String> pc, String nombre,
			int precio, String plataforma, String categoria) {
		this.ps4 = ps4;
		this.xboxone = xboxone;
		this.pc = pc;
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
	
	public String comprarKeyPs4() {
		String e = ps4.get(0);
		ps4.remove(0);
		return e;
	}
	
	public String comprarKeyXboxone() {
		String e = xboxone.get(0);
		xboxone.remove(0);
		return e;
	}
	
	public String comprarKeyPc() {
		String e = pc.get(0);
		pc.remove(0);
		return e;
	}
	
	public ArrayList<String> getPs4() {
		return ps4;
	}

	public void setPs4(ArrayList<String> ps4) {
		this.ps4 = ps4;
	}

	public ArrayList<String> getXboxone() {
		return xboxone;
	}

	public void setXboxone(ArrayList<String> xboxone) {
		this.xboxone = xboxone;
	}

	public ArrayList<String> getPc() {
		return pc;
	}

	public void setPc(ArrayList<String> pc) {
		this.pc = pc;
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
		return "Producto [id=" + id + ", ps4=" + ps4 + ", xboxone=" + xboxone + ", pc=" + pc + ", nombre=" + nombre
				+ ", precio=" + precio + ", plataforma=" + plataforma + ", categoria=" + categoria + "]";
	}
	
	
	//private static final long serialVersionUID = 1L;
    
}
