package es.urjc.code.dad.xkeys_web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "valoraciones")
public class Valoracion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String comentario;
	
	@ManyToOne
	@JsonIgnore
	private Producto productoH;


	public Valoracion(String nombre, String comentario) {
		super();
		this.nombre = nombre;
		this.comentario = comentario;
	}

	protected Valoracion() {}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Producto getProductoH() {
		return productoH;
	}

	public void setProductoH(Producto productoH) {
		this.productoH = productoH;
	}
	
	@Override
	public String toString() {
		return nombre + ": " + comentario;
	}		
}