package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

import java.util.Scanner;

/**
 * 
 * <pre>
 * 	Crea un programa que 
    • Cree un array de 100 números aleatorios entre 1000 y 2000.
    • Pregunte al usuario un número entre 1000 y 2000.
    • Cuente cuántas veces aparece en el array el número que ha introducido el usuario.
	Utiliza métodos en tu programa. Al menos:
    • Un método para generar el array de números aleatorios. Recibe la cantidad de números a generar, y devuelve un nuevo array con los números generados.
    • Un método para buscar en el array el número que ha introducido el usuario.
 * </pre>
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		int[] numeros = generarNumerosAleatorios(20, 1, 10);
		mostrarArrayNumeros(numeros);
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero.");
		int num = sc.nextInt();

		System.out.printf("El número %d aparece %d veces", num, contarCuantasVecesAparece(num, numeros));

		sc.close();
	}

	public static int contarCuantasVecesAparece(int numeroBuscado, int[] numeros) {
		int cuenta = 0;

		for (int num : numeros) {
			if (num == numeroBuscado)
				cuenta++;
		}

		return cuenta;
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

	/**
	 * Gebnera un array de números aleatorios del tamaño especificado. Cada número
	 * está entre mínimo y máximo ambos incluidos.
	 * 
	 * @param tamanio cantidad de números que se quieren generar
	 * @param minimo  valor mínimo (inclusivo) de los números generados
	 * @param maximo  valor máximo (inclusivo) de los números generados
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

}
