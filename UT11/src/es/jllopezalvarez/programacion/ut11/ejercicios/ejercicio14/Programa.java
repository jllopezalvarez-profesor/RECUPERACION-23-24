package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio14;

import java.util.Arrays;
import java.util.Random;

public class Programa {

	private static final int CANTIDAD_NUMEROS = 10;
	private static final int MAX_NUMERO = 100;
	private static Random rnd = new Random();

	public static void main(String[] args) {
		int[] numeros = new int[CANTIDAD_NUMEROS];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = rnd.nextInt(MAX_NUMERO + 1);
		}
		System.out.println(Arrays.toString(numeros));
		Arrays.sort(numeros);
		System.out.println(Arrays.toString(numeros));
	}

}
