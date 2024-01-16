package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplothrow;

import javax.management.RuntimeErrorException;

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;

	
	
	public Persona(String dni, String nombre, String apellidos) {
		checkDni(dni);
		
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	private void checkDni(String dni) {
		if (dni == null) {
			throw new RuntimeException("El DNI no puede ser null");
		}
		if (dni.length()!=9) {
			throw new RuntimeException("El DNI tiene que tener 9 caracteres");
		}
		if (!Character.isAlphabetic((dni.charAt(8)))) {
			throw new RuntimeException("El DNI tiene que terminar en letra");
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		checkDni(dni);
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

}
