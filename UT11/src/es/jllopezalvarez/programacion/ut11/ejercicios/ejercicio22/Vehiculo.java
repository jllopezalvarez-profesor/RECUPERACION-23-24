package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio22;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Vehiculo {
	private String matricula;
	private String marca;
	private String modelo;
	private Color color;

	public Vehiculo(String matricula, String marca, String modelo, Color color) {
		if (matricula == null || matricula.isBlank()) {
			throw new IllegalArgumentException("La matrícula no puede ser nula o vacía.");
		}
		if (!esMatriculaValida(matricula)) {
			throw new IllegalArgumentException("El formato de la matrícula no es válido.");
		}
		if (marca == null || marca.isBlank()) {
			throw new IllegalArgumentException("La marca no puede ser nula o vacía.");
		}
		if (modelo == null || modelo.isBlank()) {
			throw new IllegalArgumentException("El modelo no puede ser nulo o vacío.");
		}

		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	private boolean esMatriculaValida(String matricula) {
		if (matricula.length() != 7) {
			return false;
		}
		Pattern pattern = Pattern.compile("[0-9]{4}[A-Z]{3}");
		Matcher matcher = pattern.matcher(matricula);
		return matcher.matches();
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Color getColor() {
		return color;
	}

	public abstract int getTamanio();

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}

}
