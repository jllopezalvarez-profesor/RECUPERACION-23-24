package ejercicios;

import java.util.Arrays;
import java.util.Random;

public class ArraysEj16 {

	private static Random rnd = new Random();

	public static void main(String[] args) {
		/*
		 * Crea un programa que • Cree un array de 10 números aleatorios entre 1000 y
		 * 2000. • Invierta el array, de forma que el primer elemento se intercambie por
		 * el último, el segundo por el penúltimo, etc. • Mostrará el array antes y
		 * después de invertirlo. Utiliza métodos en tu programa. Al menos: • Un método
		 * para generar un número entero aleatorio entre dos valores (ambos incluidos)
		 * que recibe como parámetro. • Un método para generar el array de números
		 * aleatorios. Recibe la cantidad de números a generar, y devuelve un nuevo
		 * array con los números generados. Usa el método anterior para generar los
		 * números • Un método para invertir el contenido del array. Este método
		 * devuelve void, por lo que modifica el array, no devuelve un nuevo array. • Un
		 * método para mostrar el contenido del array.
		 */

		int[] numeros = generarArrayAleatorios(10, 1000, 2001);
		mostrarArray(numeros);
		mostrarArray2(numeros);
		mostrarArray3(numeros);
		mostrarArray4(numeros);
		System.out.println(Arrays.toString(numeros));
		invertirArray(numeros);
		System.out.println(Arrays.toString(numeros));
		
		
	

	}
	
	private static void invertirArray(int[] numeros) {
		
		int posInicial= 0;
		int posFinal = numeros.length-1;
		
		while (posFinal > posInicial) {
			int aux = numeros[posFinal];
			numeros[posFinal] = numeros[posInicial];
			numeros[posInicial]=aux;
			posInicial++;
			posFinal--;
		}
		
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	private static int generarAleatorio(int min, int max) {
		return rnd.nextInt(min, max);
	}

	private static int[] generarArrayAleatorios(int cantidadNumeros, int min, int max) {
		int[] numeros = new int[cantidadNumeros];

		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = generarAleatorio(min, max);
		}

		return numeros;
	}

	private static void mostrarArray(int[] numeros) {
		for (int num : numeros) {
			System.out.printf("%d ", num);
		}
		System.out.println();
	}
	
	private static void mostrarArray2(int[] numeros) {
		boolean esPrimero = true;
		for (int num : numeros) {
			if (esPrimero) {
				esPrimero = false;
			}else {
				System.out.print(",");
			}
			System.out.printf("%d", num);
		}
		System.out.println();
	}
	
	private static void mostrarArray3(int[] numeros) {
		String salida = "";
		for (int num : numeros) {
			salida += num + "," ;
		}
		salida = salida.substring(0, salida.length()-1);
		System.out.println(salida);
	}
	
	private static void mostrarArray4(int[] numeros) {
		String salida = "";
		for (int num : numeros) {
			salida += "," + num;
		}
		salida = salida.substring(1, salida.length());
		System.out.println(salida);
	}


}
