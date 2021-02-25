package es.urjc.code.dad.xkeys_web;

//@Entity
public class Cliente {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String contraseña;
	private String correo;
	
	protected Cliente() {}
	
	public Cliente (String nombre, String contraseña, String correo) {
		
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.correo=correo;
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", contraseña=" + contraseña + ", correo=" + correo + "]";
	}

	//DEPENDENCIAS, CARRITO, VALORACIONES, ETC

}
