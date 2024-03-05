package org.pendientes.febrero.ejercicio01;

import java.util.Scanner;

public class Programa1Ejercicio1 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Introduce cantidad de numeros");
		int cantidad = sc.nextInt();

		int[] numeros = crearyRellenarArray(cantidad, sc);

		System.out.println("Introduce limite");
		int limite = sc.nextInt();

		mostrarArray(numeros);

		procesarArray(numeros, limite);

		System.out.println("Array cambiado segun lo pedido:");
		mostrarArray(numeros);
	}

	// 0,25 puntos
	/**
	 * método que recibe el tamaño de un array, lo crea y devuelve con los valores
	 * que va pidiendo al usuario
	 * 
	 * @param tam tamaño del array
	 * @param sc  objeto Scanner para leer datos del teclado
	 * @return array con los "tam" enteros introducidos por el usuario
	 */
	public static int[] crearyRellenarArray(int tam, Scanner sc) {
		int[] numeros = new int[tam];

		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("Introduce el número para la posición %d: ", i);
			// Esta falla porque ya se ha leido un número en main con nextInt
			// numeros[i] = Integer.parseInt(sc.nextLine());
			numeros[i] = sc.nextInt();
		}

		return numeros;
	}

	// 1 punto
	/**
	 * Método que recibe un array con números enteros y realiza lo pedido en el
	 * enunciado.
	 * 
	 * @param array
	 * @param lim   número que sustituye a algunos elementos del array
	 */
	public static void procesarArray(int[] array, int lim) {
		int cantidadSustituida = 0;
		int sumaSustituidos = 0;
		int maximoSustituido = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			int numero = array[i];
			if (numero < lim) {
				array[i] = lim;
				cantidadSustituida++;
				sumaSustituidos += numero;
				if (numero > maximoSustituido) {
					maximoSustituido = numero;
				}
			}
		}
		if (cantidadSustituida == 0) {
			System.out.println("No hay valores por debajo del límite");
		} else
			System.out.printf("Valores sustituidos %d. Suma de los sustituidos %d. Mayor de los sustituidos: %d\n", cantidadSustituida, sumaSustituidos, maximoSustituido);
		{

		}

	}

	// 0,25 puntos
	/**
	 * Método que muestra por consola el contenido del array recibido
	 * 
	 * @param array
	 */
	public static void mostrarArray(int[] array) {
		for (int numero : array) {
			System.out.printf("%d ", numero);
		}
		System.out.println();
	}

}
