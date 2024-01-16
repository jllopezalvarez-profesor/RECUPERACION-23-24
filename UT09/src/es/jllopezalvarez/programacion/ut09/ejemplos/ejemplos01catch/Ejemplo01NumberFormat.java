package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.Scanner;

public class Ejemplo01NumberFormat {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Pedimos un número al usuario
		System.out.println(
				"Introduce un número entero. Si se introduce algo que no pueda convertirse a número se producirá un error");

		// Leemos el número, usando nextLine()
		// Convertimos el número. Si la cadena introducida no puede convertirse a
		// entero, se produce un error.
		String cadena = scanner.nextLine();
		int numero = Integer.parseInt(cadena);

		// Si en lugar de los dos pasos anteriores se hace sólo uno usando el método
		// nextInt, tambien falla si se introduce un valor no válido, pero la excepción
		// que se lanza es InputMismatchException.
		// int numero = scanner.nextInt();

		// Mostramos el número en pantalla. Esto no se llega a ejecutar si se produce un
		// error (excepción) en la conversión.
		System.out.printf("Número convertido: %d\n", numero);

		scanner.close();
	}
}
