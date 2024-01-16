package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18A;

public class Flauta extends Viento {
	private static final int DIFICULTAD = 6;
	private static final Material MATERIAL = Material.MADERA;
	private static final String NOMBRE_INSTRUMENTO = "flauta";
	
	public Flauta(String propietario) {
		super(propietario, DIFICULTAD, MATERIAL);
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
		return String.format("Flauta - Propietario: %s - Dificultad: %s - Material: %s", getPropietario(),
				getDificultad(), getMaterial());
	}
}
