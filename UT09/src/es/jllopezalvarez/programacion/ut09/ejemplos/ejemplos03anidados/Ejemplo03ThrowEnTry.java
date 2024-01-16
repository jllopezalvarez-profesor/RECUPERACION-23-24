package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos03anidados;

public class Ejemplo03ThrowEnTry {

	public static void main(String[] args) {

		int numero = convertirAEntero("dede");
		
		
	}

	private static int convertirAEntero(String string) {
		try {
			// Pasa algo que tenga que lanzar excepción
			throw new IllegalArgumentException("El valor recibido no me gusta");
			
		}catch (IllegalArgumentException e) {
			System.out.println("Error capturado");
			return 0;
		}
	}

}
