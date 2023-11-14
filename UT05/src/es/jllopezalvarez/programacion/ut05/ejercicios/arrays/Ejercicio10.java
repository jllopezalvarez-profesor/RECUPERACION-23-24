package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

/**
 * 
 * <pre>
 * 	Escribe un programa que:
	    • Cree un array con 20 números enteros aleatorios entre 1 y 20, ambos incluidos.
	    • Muestre el array en la consola, con los valores separados por comas.
	    • Procese el array, poniendo un cero en las posiciones que contengan un número primo.
	    • Muestre de nuevo el array en la consola.
	Para ello, usar:
	    • Un método para generar un array de números aleatorios de un tamaño dado. Recibe el tamaño del array y devuelve un array de números de la longitud indicada, lleno de números aleatorios. Para generar los números aleatorios, este método utilizará el método mencionado anteriormente.
	    • Un método para calcular si un número es primo o no. Recibe un número y devuelve un boolean indicando si el número es primo o no.
	    • Un método para mostrar el contenido de un array de enteros. Recibe el array y muestra por pantalla (consola) todos los valores del array, separados por coma. No tiene que haber coma al final, tras el último número.
 * </pre>
 *
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		int[] numeros = generarNumerosAleatorios(20, 1, 20);
		mostrarArrayNumeros(numeros);
//		mostrarArrayNumeros2(numeros);
//		mostrarArrayNumeros3(numeros);
		cambiarPrimosPorCeros(numeros);
		mostrarArrayNumeros(numeros);
	}

	public static void cambiarPrimosPorCeros(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			if (esPrimo(numeros[i])) {
				numeros[i] = 0;
			}
		}

	}

	public static void mostrarArrayNumeros(int[] numeros) {
		boolean enPrimerElemento = true;
		for (int numero : numeros) {
			if (enPrimerElemento) {
				System.out.printf("%d", numero);
				enPrimerElemento = false;
			} else {
				System.out.printf(",%d", numero);
			}
		}
		System.out.println();
	}

	public static void mostrarArrayNumeros2(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			if (i == 0) {
				System.out.printf("%d", numeros[i]);
			} else {
				System.out.printf(",%d", numeros[i]);
			}
		}
		System.out.println();
	}

	public static void mostrarArrayNumeros3(int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			if (i < numeros.length - 1) {
				System.out.printf("%d,", numeros[i]);
			} else {
				System.out.printf("%d", numeros[i]);
			}
		}
		System.out.println();
	}

	/**
	 * Gebnera un array de números aleatorios del tamaño especificado. Cada número
	 * está entre mínimo y máximo ambos incluidos.
	 * 
	 * @param tamanio cantidad de números que se quieren generar
	 * @param minimo valor mínimo (inclusivo) de los números generados
	 * @param maximo valor máximo (inclusivo) de los números generados
	 * @return el array con los números generados
	 */
	public static int[] generarNumerosAleatorios(int tamanio, int minimo, int maximo) {
		int[] numeros = new int[tamanio];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = generarNumeroAleatorio(minimo, maximo);
		}
		return numeros;
	}

	/**
	 * Genera un numero aleatorio entre un mínimo y máximo
	 * 
	 * @param minimo el valor mínimo (incluido) a generar
	 * @param maximo el valor máximo (incluido) a generar
	 * @return un aleatorio entre minimo y maximo incluidos
	 */
	public static int generarNumeroAleatorio(int minimo, int maximo) {

		return (int) (Math.random() * (maximo - minimo + 1)) + minimo;

	}

	static boolean esPrimo(int numero) {
		if (numero < 2)
			return false;
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}
		return true;
	}

}
