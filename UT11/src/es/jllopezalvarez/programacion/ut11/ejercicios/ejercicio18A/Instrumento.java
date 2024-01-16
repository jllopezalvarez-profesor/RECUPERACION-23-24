package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18A;

public abstract class Instrumento {

	private String propietario;
	private int dificultad;

	public Instrumento(String propietario, int dificultad) {
		this.propietario = propietario;
		this.dificultad = dificultad;
	}

	public String getPropietario() {
		return propietario;
	}

	public int getDificultad() {
		return dificultad;
	}

	public abstract void tocar();

	public abstract void parar();

	public boolean esMasDificil(Instrumento otro) {
		if (otro == null)
			throw new IllegalArgumentException("El instrumento a comparar no puede ser null.");
		return this.dificultad > otro.dificultad;
	}
}
