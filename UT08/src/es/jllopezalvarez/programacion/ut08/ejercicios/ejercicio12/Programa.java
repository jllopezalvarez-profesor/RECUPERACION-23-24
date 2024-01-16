package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Programa {

	private static final int CANTIDAD_NUMEROS = 100;
	private static final int NUM_MAX = 1000;
	private static final int[] PRIMOS = { 2, 3, 5, 7 };

	private static Random random = new Random(1);

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			numeros.add(random.nextInt(NUM_MAX) + 1);
		}

		Map<Integer, List<Integer>> multiplos = new HashMap<>();

		for (Integer numero : numeros) {
			for (Integer primo : PRIMOS) {
				if (numero % primo == 0) {
					multiplos.putIfAbsent(primo, new ArrayList<>());
					//multiplos.put(primo, new ArrayList<>());
					multiplos.get(primo).add(numero);
				}
			}
		}

//		for (Integer primo : PRIMOS) {
//			multiplos.put(primo, new ArrayList<>());
//			for (Integer numero : numeros) {
//				if (numero % primo == 0) {
//					multiplos.get(primo).add(numero);
//				}
//			}
//		}

		System.out.println(numeros);

		for (Map.Entry<Integer, List<Integer>> entry : multiplos.entrySet()) {
			System.out.printf("Múltiplos de %d:\n%s\n", entry.getKey(), entry.getValue());

		}
	}
}
