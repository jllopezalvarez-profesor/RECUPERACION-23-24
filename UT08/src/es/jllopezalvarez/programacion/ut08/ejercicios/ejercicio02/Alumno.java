package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio02;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno {
	private final String nif;
	private String nombre;
	private String apellidos;
	private String ciclo;
	private int curso;
	private LocalDate fechaNacimiento;

	public Alumno(String nif) {
		this.nif = nif;
	}

	public Alumno(String nif, String nombre, String apellidos, String ciclo, int curso, LocalDate fechaNacimiento) {
		this.nif = nif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciclo = ciclo;
		this.curso = curso;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNif() {
		return nif;
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

	public String getCiclo() {
		return ciclo;
	}

	public int getCurso() {
		return curso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nif);
		builder.append(" - ");
		builder.append(nombre);
		builder.append(" ");
		builder.append(apellidos);
		builder.append(" - ");
		builder.append(ciclo);
		builder.append(" - Curso ");
		builder.append(curso);
		builder.append(" - Fecha nacimiento: ");
		builder.append(fechaNacimiento);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
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
		return Objects.equals(nif, other.nif);
	}
	
	
}
