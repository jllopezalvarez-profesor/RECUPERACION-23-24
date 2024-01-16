package es.jllopezalvarez.programacion.ut08.ejemplos.ejemplos02arraylist;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
	private int id;
	private String nombre;

	public Alumno() {
	}

	public Alumno(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alumno [id=");
		builder.append(id);
		builder.append(", ");
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
		}
		builder.append("]\n");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Alumno o) {
		return Integer.compare(this.id, o.id);
	}

	
}










