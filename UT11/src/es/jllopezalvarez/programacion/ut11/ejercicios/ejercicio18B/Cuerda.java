package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18B;

public abstract class Cuerda extends Instrumento implements Afinable {
	private int numCuerdas;

	public Cuerda(String propietario, int dificultad, int numCuerdas) {
		super(propietario, dificultad);
		this.numCuerdas = numCuerdas;
	}

	public int getNumCuerdas() {
		return numCuerdas;
	}

	@Override
	public void afinar() {
		System.out.printf("Afinando un instrumento de %s.\n", this.getPropietario());
		
	}
}
