package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos03anidados;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejemplo01TryEnTry {
	public static void main(String[] args) {

		// Creamos el scanner
		Scanner scanner = new Scanner("1 2 3 4 5 A 7 B 9 0");

		int numero = 0;
		do {
			try {
				// Leemos cadena del scanner
				String cadena = scanner.next();
				try {
					numero = Integer.parseInt(cadena);
					// Sólo mostramos números impares
					if (numero % 2 != 0) {
						System.out.println("Número impar leído: " + numero);
					}
				} catch (NumberFormatException e) {
					// Captura del error en el try "interior"
					System.out.printf("Número entero incorrecto: %s\n", cadena);
				}
			} catch (NoSuchElementException e) {
				// Captura del error en el try "exterior"
				System.out.println("No quedan elementos en el scanner");
			} catch (IllegalStateException e) {
				// Captura del error en el try "exterior"
				System.out.println("El scanner está cerrado.");
			}

		} while (numero != 0);

		scanner.close();
	}
}
