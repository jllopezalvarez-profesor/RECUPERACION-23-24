package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

/**
 * 
 * Escribe un programa que genere 20 números enteros aleatorios entre 0 y 99 y
 * los almacene en un array. Usando métodos, calcula la suma de los números que
 * están en posiciones pares, y la media de los que están en impares.
 *
 */
public class Ejercicio08 {

	public static void main(String[] args) {

		int[] numeros = generaAleatorios(20, 100);
		System.out.printf("La suma de los numeros en posición par es %d.\n", sumaPosicionesPares(numeros));
		System.out.printf("La media de los numeros en posición impar es %.4f", mediaPosicionesImpares(numeros));
	}

	public static int sumaPosicionesPares(int[] numeros) {
		int suma = 0;
		for (int i = 0; i < numeros.length; i += 2) {
			suma += numeros[i];
		}
		return suma;
	}

	public static int sumaPosicionesImpares(int[] numeros) {
		int suma = 0;
		for (int i = 1; i < numeros.length; i += 2) {
			suma += numeros[i];
		}
		return suma;
	}

	public static double mediaPosicionesImpares(int[] numeros) {
		int suma = sumaPosicionesImpares(numeros);
		int numeroPosiciones = numeros.length / 2;
		if (numeros.length % 2 != 0)
			numeroPosiciones++;
		return (double) suma / numeroPosiciones;
	}

	private static int[] generaAleatorios(int cantidadNumeros, int limite) {
		// Crear un array de tamaño "cantidadNumeros"
		// Llenarlo con numeros aleatorios del 0 a limite-1 ambos incluidos
		// Devolver el array creado
		int[] numeros = new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * limite);
		}
		return numeros;
	}

}
