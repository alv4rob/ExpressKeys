package es.urjc.code.dad.xkeys_web;

//@Entity
public class Producto {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String key;
	private String nombre;
	private int precio;
	private String plataforma; 
    private String categoria;
    
	public Producto(String key, String nombre, int precio, String plataforma, String categoria) {
		
		this.key = key;
		this.nombre = nombre;
		this.precio = precio;
		this.plataforma = plataforma;
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
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
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", key=" + key + ", nombre=" + nombre + ", precio=" + precio + ", plataforma="
				+ plataforma + ", categoria=" + categoria + "]";
	}
    
}
