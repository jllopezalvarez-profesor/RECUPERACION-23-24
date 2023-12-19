package ejemplos.clases;

public class Persona {
	private final String dni;
	private String nombre;
	private String apellidos;
	
	public final static int N = 4;

	public Persona(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos=apellidos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		int n = 3;
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

}
