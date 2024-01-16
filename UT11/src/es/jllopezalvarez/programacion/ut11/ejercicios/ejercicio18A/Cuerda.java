package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18A;

public abstract class Cuerda extends Instrumento {
	private int numCuerdas;

	public Cuerda(String propietario, int dificultad, int numCuerdas) {
		super(propietario, dificultad);
		this.numCuerdas = numCuerdas;
	}

	public int getNumCuerdas() {
		return numCuerdas;
	}

}
