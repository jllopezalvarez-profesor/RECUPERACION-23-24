package org.pendientes.febrero.ejercicio03;

import java.util.Objects;

public class Mascota implements Comparable<Mascota>  {
	private final int id;
	private final String nombre;
	private final String propietario;
	private final int edadMeses;
	private final double pesoKg;

	public Mascota(int id, String nombre, String propietario, int edadMeses, double pesoKg) {
		this.id = id;
		this.nombre = nombre;
		this.propietario = propietario;
		this.edadMeses = edadMeses;
		this.pesoKg = pesoKg;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPropietario() {
		return propietario;
	}

	public int getEdadMeses() {
		return edadMeses;
	}

	public double getPesoKg() {
		return pesoKg;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", propietario=" + propietario + ", edadMeses=" + edadMeses
				+ ", pesoKg=" + pesoKg + "]";
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
		Mascota other = (Mascota) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Mascota that) {
		// Comparar this con that
		// Si this va antes en el orden natural que taht, devolvemos < 0 (-1)
		// Si this y that van a la par (en el mismo sitio en el orden natural) devolver 0
		// Si this va después en el orden natural que that, devolvemos > 0 (1)

		// Forma "rústica"
//		if (this.id < that.id) {
//			return -1;
//		}
//		if (this.id > that.id) {
//			return 1;
//		}
//		return 0;
		
		return Integer.compare(this.id, that.id);
		
		// Si el orden natural es de mayot a menor hay dos opciones
		// Opcion 1: invertir el resultado
		//return -Integer.compare(this.id, that.id);
		// Opción 2: invertir el orden de los parámetros
		//return Integer.compare(that.id, this.id);		
		
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(id);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!(obj instanceof Mascota))
//			return false;
//		Mascota other = (Mascota) obj;
//		return id == other.id;
//	}
	
	
	
	
	
}
