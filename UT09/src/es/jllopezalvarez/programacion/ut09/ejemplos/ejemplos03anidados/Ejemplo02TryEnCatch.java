package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos03anidados;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejemplo02TryEnCatch {
	public static void main(String[] args) {

		// Creamos el scanner, vacío para que falle.
		Scanner scanner = new Scanner("");

		try {

			int numero = 0;

			try {
				// Leemos números del scanner. ESto va a fallar si no tiene datos
				numero = scanner.nextInt();
				// Mostramos el número leído
				System.out.println("Número leído: " + numero);

			} catch (NoSuchElementException e) {
				// Damos un valor al número usando un parseInt que fallará
				try {
					numero = Integer.parseInt("ABCD");
				} catch (NumberFormatException e2) {
					System.out.println("Se ha producido un error.");
					System.out.println("Damos un valor 100 al número.");
					numero = 100;
				}
			} finally {
				// Esto se ejecutará para cada número, incluidos los pares.
				System.out.println("En finally - número leído: " + numero);
			}

		} finally {
			// Este segundo finally es para garantizar el cierre del scanner.
			System.out.println("Cerrando scanner");
			if (scanner != null)
				scanner.close();
		}
	}
}
