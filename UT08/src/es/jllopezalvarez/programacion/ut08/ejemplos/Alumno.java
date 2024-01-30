package es.jllopezalvarez.programacion.ut08.ejemplos;

import java.time.LocalDate;
import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
	private static final int PESO_DEFECTO = 10;
	
	private final int id;
	private final String nombre;
	private LocalDate fechaNacimiento;
	
	
	public Alumno(int id, String nombre, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	


	@Override
	public String toString() {
		return id + " - " + nombre + " - " + fechaNacimiento;
	}




	public Alumno(int id, String nombre) {
		this(id, nombre, LocalDate.now());
		
//		this.id = id;
//		this.nombre = nombre;
//		this.fechaNacimiento = LocalDate.now();
	}




	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Alumno))
			return false;
		Alumno other = (Alumno) obj;
		return id == other.id;
	}




	@Override
	public int compareTo(Alumno other) {
		return Integer.compare(id, other.id);
	}
	
	
	
	

}
