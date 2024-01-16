package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.util.Objects;

class Becario implements Comparable<Becario> {
	private String nombre;
	private String apellido;
	private int edad;
	private int numSuspensos;
	private boolean viveSolo;
	private double ingresos;

	public Becario(String nombre, String apellido, int edad, int numSuspensos, boolean viveSolo, double ingresos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.numSuspensos = numSuspensos;
		this.viveSolo = viveSolo;
		this.ingresos = ingresos;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public int getNumSuspensos() {
		return numSuspensos;
	}

	public boolean isViveSolo() {
		return viveSolo;
	}

	public double getIngresos() {
		return ingresos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Becario other = (Becario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Becario o) {
		int comparacion = this.nombre.compareTo(o.nombre);
		if (comparacion == 0) {
			return this.apellido.compareTo(o.apellido);
		}
		return comparacion;
	}

}