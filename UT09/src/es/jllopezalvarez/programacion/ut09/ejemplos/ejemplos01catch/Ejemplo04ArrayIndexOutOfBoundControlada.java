package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.Random;
import java.util.Scanner;

public class Ejemplo04ArrayIndexOutOfBoundControlada {

	private static final int CANTIDAD_NUMEROS = 10;

	public static void main(String[] args) {

		int[] numeros = new int[CANTIDAD_NUMEROS];

		Random rnd = new Random();

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rnd.nextInt();
		}

		Scanner scanner = new Scanner(System.in);

		int posicion;
		do {
			System.out.println("¿Qué posición del array de aleatorios quieres consultar?");
			System.out.printf("0 a %d, -1 para terminar\n", CANTIDAD_NUMEROS - 1);
			// Si el usuario introduce un valor que no es válido para la conversión de
			// String a int (no es un número entero) se producirá una excepción de tipo
			// InputMismatchException en nextInt(). Esta excepción no está controlada, por lo
			// que provocará el final del programa si se produce.
			posicion = scanner.nextInt();
			if (posicion != -1) {
				// Si el usuario introduce un número que sale del rango del array
				// (0..CANTIDAD_NUMEROS-1) se producirá una excepción
				// ArrayIndexOutOfBoundsException. Como la estamos controlando con un try/catch,
				// podemos mostrar un mensaje de error que indica al usuario el problema y no
				// provoca la detención del programa.
				try {
					System.out.printf("La posición %d del array contiene el número %d\n", posicion, numeros[posicion]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("El número está fuera de los límites del array. Intenta otro número.");
				}
			}
		} while (posicion != -1);

		scanner.close();
	}
}
