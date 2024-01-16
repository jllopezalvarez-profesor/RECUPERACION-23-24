package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos09repaso;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private int estaturaEnCm;

	public Persona(int id, String nombre, String apellido, LocalDate fechaNacimiento,
			int estaturaEnCm) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.estaturaEnCm = estaturaEnCm;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getEstaturaEnCm() {
		return estaturaEnCm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", estaturaEnCm=");
		builder.append(estaturaEnCm);
		builder.append("]");
		return builder.toString();
	}

}
