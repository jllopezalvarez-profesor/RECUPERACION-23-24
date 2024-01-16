package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos04lanzamiento;

public class Ejemplo03RelanzadoExcepciones {
	public static void main(String[] args) {
		System.out.println("Inicio del programa");
		try {
			System.out.println(convertirANumero("100"));
			System.out.println(convertirANumero("HOLA"));
		} catch (NumberFormatException e) {
			System.out.println("Excepción capturada en el programa principal.");
			e.printStackTrace();
		}
		System.out.println("Fin del programa");
	}

	private static int convertirANumero(String cadena) {
		try {
			return Integer.parseInt(cadena);
		} catch (NumberFormatException e) {
			System.out.println("Excepción capturada en el método.");
			System.out.println("Relanzamos la excepción.");
			throw e;
		}
	}
}
