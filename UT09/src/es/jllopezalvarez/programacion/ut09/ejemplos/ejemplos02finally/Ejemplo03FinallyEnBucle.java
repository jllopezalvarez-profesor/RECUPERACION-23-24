package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos02finally;

import java.util.Scanner;

public class Ejemplo03FinallyEnBucle {
	public static void main(String[] args) {

		// Creamos el scanner
		Scanner scanner = new Scanner("1 2 3 4 5 6 7 8 9 0");

		int numero = 0;
		do {

			try {
				// Leemos números del scanner
				numero = scanner.nextInt();
				// Saltamos los números pares
				if (numero % 2 == 0)
					continue;
				// Mostramos el número impar leído
				System.out.println("Número impar leído: " + numero);
			} finally {
				// Esto se ejecutará para cada número, incluidos los pares.
				System.out.println("En finally - número leído: " + numero);
			}

		} while (numero != 0);
		
		scanner.close();
	}
}
