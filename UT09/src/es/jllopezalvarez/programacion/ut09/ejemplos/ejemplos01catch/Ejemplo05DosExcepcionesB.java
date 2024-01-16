package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos01catch;

import java.util.Random;
import java.util.Scanner;

public class Ejemplo05DosExcepcionesB {

	private static final int CANTIDAD_NUMEROS = 10;

	public static void main(String[] args) {

		int[] numeros = new int[CANTIDAD_NUMEROS];

		Random rnd = new Random();

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rnd.nextInt();
		}

		Scanner scanner = new Scanner(System.in);

		int posicion = 0;
		do {
			System.out.println("¿Qué posición del array de aleatorios quieres consultar?");
			System.out.printf("0 a %d, -1 para terminar\n", CANTIDAD_NUMEROS - 1);
			try {
				// Si el usuario introduce un valor que no es válido para la conversión de
				// String a int (no es un número entero) se producirá una excepción de tipo
				// InputMismatchException en nextInt().
				// En este caso sí que la podemos controlar, porque está dentro del try, y
				// tenemos un catch específico para esta clase de excepciones
				posicion = Integer.parseInt(scanner.nextLine());
				if (posicion != -1) {
					// Si el usuario introduce un número que sale del rango del array
					// (0..CANTIDAD_NUMEROS-1) se producirá una excepción
					// ArrayIndexOutOfBoundsException. Como la estamos controlando con un try/catch,
					// podemos mostrar un mensaje de error que indica al usuario el problema y no
					// provoca la detención del programa.
					System.out.printf("La posición %d del array contiene el número %d\n", posicion, numeros[posicion]);
				}
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("El valor introducido no es válido.");
				System.out.println("Mensaje de error: " + e.getMessage());
				System.out.println("Mensaje localizado: " + e.getLocalizedMessage());
			}
		} while (posicion != -1);

		scanner.close();
	}
}
