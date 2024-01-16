package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio15;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Programa {

	// 1 2 3 4 X HOLA 6
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce una línea de números separados por espacios o tabuladores.");
		String lineaNumeros = scanner.nextLine();

		PriorityQueue<Integer> numeros = new PriorityQueue<>();
		Map<Integer, Integer> mapa = new TreeMap<>(Comparator.reverseOrder());

		try (Scanner scannerLinea = new Scanner(lineaNumeros)) {
			while (scannerLinea.hasNext()) {
				try {
					int numero = scannerLinea.nextInt();
					numeros.add(numero);
//					if (mapa.containsKey(numero)) {
//						int cantidad = mapa.get(numero);
//						mapa.put(numero, cantidad + 1);
//					} else {
//						mapa.put(numero, 1);
//					}
					
					mapa.put(numero, mapa.getOrDefault(numero, 0)+1);

				} catch (InputMismatchException e) {
					System.out.printf("'%s' no es un número válido.\n", scannerLinea.next());
				}
			}
		}

		// -----------------------
		// | Clave | Valor |
		// -----------------------

		System.out.println("Números encontrados:");
		Integer num;
		while ((num = numeros.poll()) != null) {
			System.out.printf("%s ", num);
		}
		System.out.println();

//		System.out.println(numeros);
		System.out.println("Frecuencias de los números:");
		System.out.println("--------------------------");
		System.out.println("| Clave    |       Valor |");
		System.out.println("--------------------------");
		for (Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			System.out.printf("| %-8.8s | %11.11s |\n", key, val);
			System.out.println("--------------------------");
		}

		// System.out.println(mapa);

	}

}
