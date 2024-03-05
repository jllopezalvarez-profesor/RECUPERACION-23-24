package org.pendientes.febrero.ejercicio03;

public class Mascota {
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
	
	
}
