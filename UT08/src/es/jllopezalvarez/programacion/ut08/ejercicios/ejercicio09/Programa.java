package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio09;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Programa {

	private static final int LIMITE_NUMEROS = 8;
	private static final int CANTIDAD_NUMEROS = 30;

	public static void main(String[] args) {
		List<Integer> numeros = new LinkedList<>();
		

		Random random = new Random();
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			numeros.add(random.nextInt(LIMITE_NUMEROS) + 1);
		}

		// Map<Integer, Integer> mapa = new HashMap<>(); // No se garantiza orden
		// Map<Integer, Integer> mapa = new LinkedHashMap<>(); // En orden de inserción
		// Map<Integer, Integer> mapa = new TreeMap<>(); // Orden natural
		Map<Integer, Integer> mapa = new TreeMap<>(Comparator.reverseOrder()); // Orden natural inverso
		
		
		for (Integer numero : numeros) {
			mapa.put(numero, mapa.getOrDefault(numero, 0) + 1);

//			if (mapa.containsKey(numero)) {
//				Integer valorPrevio = mapa.get(numero);
//				Integer nuevoValor = valorPrevio + 1;
//				mapa.put(numero, nuevoValor);
//			} else {
//				// Primera vez que aparece
//				mapa.put(numero, 1);
//			}
		}

		System.out.println(numeros);

		for (Map.Entry<Integer, Integer> entrada : mapa.entrySet()) {
			System.out.printf("%d aparece %d veces\n", entrada.getKey(), entrada.getValue());
		}
	}
}
