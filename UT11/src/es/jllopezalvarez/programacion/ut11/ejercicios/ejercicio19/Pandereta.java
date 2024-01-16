package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio19;

public class Pandereta extends Percusion {
	private static int DIFICULTAD = 4;
	private static String NOMBRE_INSTRUMENTO = "pandereta";

	public Pandereta(String propietario) {
		super(propietario, DIFICULTAD);
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
		return String.format("Pandereta - Propietario: %s - Dificultad: %s", getPropietario(), getDificultad());
	}
}
