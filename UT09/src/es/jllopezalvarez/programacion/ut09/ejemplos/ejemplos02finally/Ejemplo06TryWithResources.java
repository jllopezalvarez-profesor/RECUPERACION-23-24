package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos02finally;

import java.util.Scanner;

public class Ejemplo06TryWithResources {

	public static void main(String[] args) {

		// El scanner se abre dentro de try-with-resources, 
		// y se cierra automáticamente al salir. 
		// No es necesario el bloque finally ni llamar a close().
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Introduce un número entero");

			// Esto puede fallar con distintas excepciones.
			int numero = scanner.nextInt();

			System.out.printf("Número leído: %d\n", numero);
		}
	}

}
