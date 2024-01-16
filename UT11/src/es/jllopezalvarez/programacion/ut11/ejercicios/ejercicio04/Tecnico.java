package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio04;

public class Tecnico extends Operario {
	public Tecnico(String nombre) {
		super(nombre);
		// System.out.println("En el constructor con parámetro de Oficial");
	}

	@Override
	public String toString() {
		return String.format("Empleado %s -> Operario -> Tecnico", getNombre());
	}
}
