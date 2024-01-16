package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio18A;

public class Timbales extends Percusion implements Afinable{
	private static int DIFICULTAD = 6;
	private static String NOMBRE_INSTRUMENTO = "timbales";

	public Timbales(String propietario) {
		super(propietario, DIFICULTAD);
	}

	@Override
	public void tocar() {
		System.out.printf("Los %s de %s comienzan a tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public void parar() {
		System.out.printf("Los %s de %s dejan de tocar.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}

	@Override
	public String toString() {
		return String.format("Timbales - Propietario: %s - Dificultad: %s", getPropietario(), getDificultad());
	}
	
	@Override
	public void afinar() {
		System.out.printf("Afinando los %s de %s.\n", NOMBRE_INSTRUMENTO, this.getPropietario());
	}
}
