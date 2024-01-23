package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio19;

public class Guitarra extends CuerdaPulsada implements Afinable {
	private static final int DIFICULTAD = 7;
	private static final int NUM_CUERDAS = 6;
	private static final String NOMBRE_INSTRUMENTO = "guitarra";


	public Guitarra(String propietario) {
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
		return String.format("Guitarra - Propietario: %s - Dificultad: %s - Número de cuerdas: %s", getPropietario(),
				getDificultad(), getNumCuerdas());
	}
	
	@Override
	public void afinar() {
		System.out.printf("Afinando el %s de %s.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}
}