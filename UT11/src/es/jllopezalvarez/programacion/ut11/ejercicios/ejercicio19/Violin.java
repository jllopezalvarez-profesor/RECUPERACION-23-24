package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio19;

public class Violin extends CuerdaFrotada implements Afinable{
	private static final int DIFICULTAD = 9;
	private static final int NUM_CUERDAS = 4;
	private static final String NOMBRE_INSTRUMENTO = "violín";


	public Violin(String propietario) {
		super(propietario, DIFICULTAD, NUM_CUERDAS);
	}

	@Override
	public void tocar() {
		System.out.printf("El %s de %s comienza a tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public void parar() {
		System.out.printf("El %s de %s deja de tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public String toString() {
		return String.format("Violín - Propietario: %s - Dificultad: %s - Número de cuerdas: %s", getPropietario(),
				getDificultad(), getNumCuerdas());
	}
	@Override
	public void afinar() {
		System.out.printf("Afinando el %s de %s.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}
}
