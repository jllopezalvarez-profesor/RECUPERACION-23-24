package ejemplos;

public class Persona {
	private final int dni;
	private String nombreApellidos;

	public Persona(int dni, String nombreApellidos) {
		super();
		this.dni = dni;
		this.nombreApellidos = nombreApellidos;
	}

	public String getNombreApellidos() {
		return nombreApellidos;
	}

	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}

	public int getDni() {
		return dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombreApellidos=" + nombreApellidos + "]";
	}

}
