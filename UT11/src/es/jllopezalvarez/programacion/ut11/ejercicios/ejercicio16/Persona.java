package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio16;

import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Comparable<Persona> {
	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;

	public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return this.dni + " - " + this.nombre + " " + this.apellidos + " - " + this.fechaNacimiento;
	}

	@Override
	public int compareTo(Persona otro) {
		return this.nombre.compareTo(otro.nombre);
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
		return Objects.equals(dni, other.dni);
	}

}
