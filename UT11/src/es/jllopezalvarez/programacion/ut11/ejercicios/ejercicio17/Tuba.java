package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio17;

public class Tuba extends Viento {
	private static final int DIFICULTAD = 8;
	private static final Material MATERIAL = Material.METAL;
	private static final String NOMBRE_INSTRUMENTO = "tuba";
	
	public Tuba(String propietario) {
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
		return String.format("Tuba - Propietario: %s - Dificultad: %s - Material: %s", getPropietario(),
				getDificultad(), getMaterial());
	}
}
