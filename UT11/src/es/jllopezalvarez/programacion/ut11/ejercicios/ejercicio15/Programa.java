package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio15;

import java.util.Arrays;
import java.util.Random;

public class Programa {

	private static final int CANTIDAD_NUMEROS = 10;
	private static final int MIN_NUMERO = 1;
	private static final int MAX_NUMERO = 9999;
	private static Random rnd = new Random();

	public static void main(String[] args) {
		String[] numeros = new String[CANTIDAD_NUMEROS];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = String.valueOf(rnd.nextInt(MIN_NUMERO, MAX_NUMERO + 1));
		}
		System.out.println(Arrays.toString(numeros));
		Arrays.sort(numeros);
		System.out.println(Arrays.toString(numeros));
	}

}
