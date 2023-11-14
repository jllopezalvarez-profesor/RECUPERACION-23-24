package es.jllopezalvarez.programacion.ut05.ejercicios.arrays;

import java.util.Scanner;

public class Ejercicio14 {

	private static final int CANTIDAD_NUMS_USUARIO = 5;
	private static final int CANTIDAD_NUMS_ALEATORIOS = 25;
	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 100;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numeros = pedirNumerosAUsuario(CANTIDAD_NUMS_USUARIO, MIN_NUM, MAX_NUM, scanner);
		int[] aleatorios = generarNumerosAleatorios(CANTIDAD_NUMS_ALEATORIOS, MIN_NUM, MAX_NUM);
		boolean[] resultados = buscarNumeros(numeros, aleatorios);
		mostrarEncontrado(numeros, resultados);
		scanner.close();
	}

	private static void mostrarEncontrado(int[] numeros, boolean[] encontrados) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("%d - %sencontrado.\n", numeros[i], encontrados[i] ? "" : "no ");
		}
	}

	private static boolean[] buscarNumeros(int[] numerosBuscados, int[] numeros) {
		boolean[] resultado = new boolean[numerosBuscados.length];
		for (int i = 0; i < numerosBuscados.length; i++) {
			int numeroBuscado = numerosBuscados[i];
			boolean encontrado = false;
			for (int j = 0; j < numeros.length && !encontrado; j++) {
				if (numeros[j] == numeroBuscado)
					encontrado = true;
			}
			resultado[i] = encontrado;
		}
		return resultado;
	}

	private static int[] generarNumerosAleatorios(int cantidadNumeros, int minimo, int maximo) {
		int[] numeros = new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = generarAleatorio(minimo, maximo);
		}
		return numeros;
	}

	private static int generarAleatorio(int minimo, int maximo) {
		return (int) (Math.random() * (maximo - minimo)) + 1;
	}

	private static int[] pedirNumerosAUsuario(int cantidadNumeros, int minimo, int maximo, Scanner scanner) {
		int[] numeros = new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = pedirNumero(minimo, maximo, scanner);
		}
		return numeros;
	}

	private static int pedirNumero(int minimo, int maximo, Scanner sc){
		System.out.printf("Introduce un número entre %d y %d a.i. ", minimo, maximo);
		int numero = Integer.parseInt(sc.nextLine());
		while (numero < minimo || numero > maximo) {
			System.out.printf("Número incorrecto. Introduce un número entre %d y %d a.i. ", minimo, maximo);
			numero = Integer.parseInt(sc.nextLine());
		}
		return numero;
	}
}
