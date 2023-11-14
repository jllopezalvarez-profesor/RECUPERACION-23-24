package ejemplos.ejemplostringbuilder;

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Persona(String dni, String nombre, String apellidos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
		
		
		//return new StringBuilder().append("Hola ").append("me llamo ").append(" José Luis").toString();
	}

}
