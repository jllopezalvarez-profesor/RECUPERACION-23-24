package es.jllopezalvarez.programacion.ut08.ejemplos.ejemplos06borrado;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
	private String dni;
	private String nombre;

	public Persona(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

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

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return this.dni.equalsIgnoreCase(other.dni);
//		return Objects.equalsI(dni, other.dni);
	}

	@Override
	public int compareTo(Persona other) {
		return this.dni.compareToIgnoreCase(other.dni);
	}
	


}
