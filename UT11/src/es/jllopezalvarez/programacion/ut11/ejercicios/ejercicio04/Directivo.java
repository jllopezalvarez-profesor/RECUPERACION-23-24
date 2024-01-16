package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04;

public class Directivo extends Empleado {
	public Directivo(String nombre) {
		super(nombre);
		//System.out.println("En el constructor con parámetro de Directivo");
	}

//	@Override
//	public String toString() {
//		return String.format("Empleado %s -> Directivo", this.getNombre());
//	}

	@Override
	public String toString() {
		return String.format("%s -> Directivo", super.toString());
	}
}
