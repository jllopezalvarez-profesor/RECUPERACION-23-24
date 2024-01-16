package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18B;

public class Piano extends CuerdaPercutida {
	private static final int DIFICULTAD = 7;
	private static final int NUM_CUERDAS = 230;
	private static final String NOMBRE_INSTRUMENTO = "piano";


	public Piano(String propietario) {
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
		return String.format("Piano - Propietario: %s - Dificultad: %s - Número de cuerdas: %s", getPropietario(),
				getDificultad(), getNumCuerdas());
	}
	

}
