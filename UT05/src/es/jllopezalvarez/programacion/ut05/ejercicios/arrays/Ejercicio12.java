package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

import java.util.Scanner;

/**
 * 
 * <pre>
 * 	Crea un programa que:
    • Pregunte al usuario cuántos números desea generar, que tendrá que ser un valor entre 10 y 100 ambos incluidos. Si el usuario introduce un número menor que 10 o mayor que 100 se le volverá a preguntar. 
    • Cree un array con tantos números aleatorios como haya indicado el usuario. Cada número tendrá que ser un valor entre 0 y 1000 ambos incluidos, y no podrán repetirse, no podrá aparecer el mismo número en el array dos veces.
    • Muestre el array en pantalla.
	A tener en cuenta:
    • El array se debe crear con un método que:
        ◦ Recibe la cantidad de números a generar.
        ◦ Recibe el valor mínimo y el valor máximo para generar los números aleatorios
        ◦ Devuelve el array con los números creados.
    • El array se debe mostrar con un método que muestra los números del array separados por guiones (-).
 * </pre>
 *
 */
public class Ejercicio12 {

	private static final int MIN_CANTIDAD_NUMEROS = 10;
	private static final int MAX_CANTIDAD_NUMEROS = 100;

	private static final int MIN_NUMERO = 0;
	private static final int MAX_NUMERO = 20;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("¿Cuántos números quieres generar? (entre %d y %d a.i.) ", MIN_CANTIDAD_NUMEROS,
				MAX_CANTIDAD_NUMEROS);
		int cantidadNumeros = Integer.parseInt(scanner.nextLine());
		while (cantidadNumeros < MIN_CANTIDAD_NUMEROS || cantidadNumeros > MAX_CANTIDAD_NUMEROS) {
			System.out.println("Cantidad incorrecta.");
			System.out.printf("¿Cuántos números quieres generar? (entre %d y %d a.i.) ", MIN_CANTIDAD_NUMEROS,
					MAX_CANTIDAD_NUMEROS);
			cantidadNumeros = Integer.parseInt(scanner.nextLine());
		}

		int[] numeros = generarNumerosAleatoriosNoRepetidos2(cantidadNumeros, MIN_NUMERO, MAX_NUMERO);
		mostrarArrayNumeros(numeros);

		scanner.close();
	}

	public static void mostrarArrayNumeros(int[] numeros) {
		// TODO: Cambiar el método para que no genere repetidos.
		boolean enPrimerElemento = true;
		for (int numero : numeros) {
			if (enPrimerElemento) {
				System.out.printf("%d", numero);
				enPrimerElemento = false;
			} else {
				System.out.printf("-%d", numero);
			}
		}
		System.out.println();
	}

	/**
	 * Gebnera un array de números aleatorios del tamaño especificado. Cada número
	 * está entre mínimo y máximo ambos incluidos. No genera números repetidos.
	 * 
	 * @param tamanio cantidad de números que se quieren generar
	 * @param minimo  valor mínimo (inclusivo) de los números generados
	 * @param maximo  valor máximo (inclusivo) de los números generados
	 * @return el array con los números generados
	 */
	public static int[] generarNumerosAleatoriosNoRepetidos(int tamanio, int minimo, int maximo) {
		int[] numeros = new int[tamanio];
		for (int i = 0; i < numeros.length; i++) {
			boolean encontradoNoRepetido = false;
			while (!encontradoNoRepetido) {

				int numeroGenerado = generarNumeroAleatorio(minimo, maximo);
				boolean encontradoRepetido = false;
				for (int j = 0; j < i; j++) {
					if (numeros[j] == numeroGenerado) {
						encontradoRepetido = true;
					}
				}
				if (!encontradoRepetido) {
					numeros[i] = numeroGenerado;
					encontradoNoRepetido = true;
					mostrarArrayNumeros(numeros);
				}
			}
		}
		return numeros;
	}

	public static int[] generarNumerosAleatoriosNoRepetidos2(int tamanio, int minimo, int maximo) {
		int[] numeros = new int[tamanio];
		int i = 0;
		while (i < numeros.length) {
			// for (int i = 0; i < numeros.length;) {
			int numeroGenerado = generarNumeroAleatorio(minimo, maximo);
			boolean encontradoRepetido = false;
			for (int j = 0; j < i; j++) {
				if (numeros[j] == numeroGenerado) {
					encontradoRepetido = true;
				}
			}
			if (!encontradoRepetido) {
				numeros[i] = numeroGenerado;
				i++;
			}
			mostrarArrayNumeros(numeros);
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

}
