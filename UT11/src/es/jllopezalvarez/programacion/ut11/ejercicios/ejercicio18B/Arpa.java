package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18B;

public class Arpa extends CuerdaPulsada {
	private static final int DIFICULTAD = 10;
	private static final int NUM_CUERDAS = 47;
	private static final String NOMBRE_INSTRUMENTO = "arpa";

	public Arpa(String propietario) {
		super(propietario, DIFICULTAD, NUM_CUERDAS);
	}

	@Override
	public void tocar() {
		System.out.printf("La %s de %s comienza a tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public void parar() {
		System.out.printf("La %s de %s deja de tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public String toString() {
		return String.format("Arpa - Propietario: %s - Dificultad: %s - Número de cuerdas: %s", getPropietario(),
				getDificultad(), getNumCuerdas());
	}

}
