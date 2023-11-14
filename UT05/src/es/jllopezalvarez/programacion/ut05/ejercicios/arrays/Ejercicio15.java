package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

import java.util.Scanner;

public class Ejercicio15 {

	private static final int CANTIDAD_NUMEROS = 5;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numeros = new int[CANTIDAD_NUMEROS];

		System.out.print("Introduce un número mayor que cero: ");
		int numero = Integer.parseInt(scanner.nextLine());
		while (numero > 0) {
			System.out.printf("Antes  de  insertar %d: ", numero);
			mostrarNumeros(numeros);
			insertarNumero(numero, numeros);
			System.out.printf("Despues de insertar %d: ", numero);
			mostrarNumeros(numeros);
			
			System.out.print("Introduce un número mayor que cero: ");
			numero = Integer.parseInt(scanner.nextLine());
		}
		scanner.close();
	}

	private static void mostrarNumeros(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			if (i>0) System.out.print(",");
			System.out.print(numeros[i]);
		}
		System.out.println();
	}

	private static void insertarNumero(int numero, int[] numeros) {
		int posicionAInsertar = 0;
		// Ojo, no hago nada en el bucle porque sólo me interesa calcular la posición de
		// inserción.
		// Encuentro la posición si:
		// - Encuentro un cero (está libre)
		// - Encuentro un número mayor que el que quiero insertar
		// - He llegado al final (descarto)
		for (posicionAInsertar = 0; (posicionAInsertar < numeros.length) && (numeros[posicionAInsertar] != 0)
				&& (numeros[posicionAInsertar] <= numero); posicionAInsertar++)
			;

		// Si he llegado al final no hacemos nada, se descarta el número
		if (posicionAInsertar < numeros.length) {
			// Si hay un cero, estaba libre y puedo usar la posición
			if (numeros[posicionAInsertar] == 0) {
				numeros[posicionAInsertar] = numero;
			} else {
				desplazarValoresDerecha(numeros, posicionAInsertar);
				numeros[posicionAInsertar] = numero;
			}
		}
	}

	private static void desplazarValoresDerecha(int[] numeros, int posicionInicial) {
		for(int i=numeros.length-1; i > posicionInicial;i--) {
			numeros[i] = numeros[i - 1];
		}
	}

}
