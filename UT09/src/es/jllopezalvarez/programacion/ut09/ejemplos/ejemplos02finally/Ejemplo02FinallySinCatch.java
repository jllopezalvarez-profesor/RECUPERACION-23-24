package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos02finally;

import java.util.Scanner;

public class Ejemplo02FinallySinCatch {
	public static void main(String[] args) {

		// Creamos el scanner
		Scanner scanner = new Scanner("");
		try {
			// Esta sentencia puede lanzar distintas excepciones
			// Con el valor que se inicializa el scanner, lanzará una del tipo
			// NoSuchElementException, porque no contiene nada.
			// No tenemos bloques catch, por lo que la excepción se lanza sin ser
			// controlada.
			int numero = scanner.nextInt();
			System.out.println("El número introducido es " + numero);
		} finally {
			// Este código se ejecuta SIEMPRE que se haya llegado al try.
			System.out.println("Dentro del finally.");
			// Cerramos el scanner si es != null
			if (scanner != null)
				scanner.close();
		}
	}
}
