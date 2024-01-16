package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04;

public class Oficial extends Operario {
	public Oficial(String nombre) {
		super(nombre);
		// System.out.println("En el constructor con parámetro de Oficial");
	}

	@Override
	public String toString() {
		return String.format("%s -> Oficial", super.toString());
	}
}
