package org.pendientes.febrero.ejercicio02;

import java.util.Objects;

public class Persona {
	private final String dni;
	private final String nombre;
	private final String apellidos;

	// No está en el enunciado, pero añadimos que:
	// - El DNI no puede ser nul ni tener longitud menor de 10 caracteres
	// - El nombre y los apellidos no pueden ser nulos ni cadena vacía.
	// Si hay errores lanzar IllegalArgumentException
	
	public Persona(String dni, String nombre, String apellidos) {
		// No es obligatorio poner este super()
		// super();
		
		// Antes de guardar atributos comprobamos y lanzamos excepciones
		// MAL: if (dni.equals(null)) con null siempre == 
		if (dni == null) {
			throw new IllegalArgumentException("El DNI no puede ser nulo");
		}
		if (dni.length() != 10) {
			throw new IllegalArgumentException("El DNI debe tener 10 caracteres de longitud");
		}
		// Junto, otra forma: (el orden es impòrtante, primero null y luego la longitud):
		// MAL: if (dni.length() != 10 || dni == null )
		if (dni == null || dni.length() != 10) {
			throw new IllegalArgumentException("El DNI no puede ser nulo ni tner una longitud distinta de 10 caracteres");
		}
		
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo ni cadena vacía");
		}
		if (apellidos == null || apellidos.isEmpty()) {
			throw new IllegalArgumentException("Los apellidos no pueden ser nulo ni cadena vacía");
		}
		
		// Si todo está bien, guardo los atributos
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni.toLowerCase());
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		return this.dni.equalsIgnoreCase(other.dni);
	}
	

}
