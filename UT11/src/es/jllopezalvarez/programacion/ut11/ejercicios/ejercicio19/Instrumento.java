package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio19;

public abstract class Instrumento implements Comparable<Instrumento> {

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

	@Override
	public int compareTo(Instrumento otro) {
//		if (this.dificultad > otro.dificultad) 
//			return -1;
//		if (this.dificultad < otro. dificultad)
//			return 1;
//		return 0;

		return -Integer.compare(this.dificultad, otro.dificultad);
		// return Integer.compare(otro.dificultad, this.dificultad);
	}
}
