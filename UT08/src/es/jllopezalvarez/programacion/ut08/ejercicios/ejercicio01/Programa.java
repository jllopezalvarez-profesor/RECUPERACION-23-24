package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Programa {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Creamos el array. Como no sabemos la cantidad de elementos que vamos a
		// guardar, usamos el constructor que no recibe parámetros.
		ArrayList<Integer> numeros = new ArrayList<>();

		// Llenamos el array
		leerValoresUsuario(numeros);

		// Mostrar cantidad de números introducida
		System.out.printf("Se han introducido %d números.\n", numeros.size());

		// Mostrar media
		System.out.printf("Media (1) %.3f.\n", calcularMedia(numeros));
		System.out.printf("Media (2) %.3f.\n", calcularMedia2(numeros));
		System.out.printf("Media (2) %.3f.\n", calcularMedia3(numeros));

		// Mostrar máximo y mínimo
		System.out.printf("Máximo: %d\n", obtenerMaximo(numeros));
		System.out.printf("Mínimo: %d\n", obtenerMinimo(numeros));

	}

	private static double calcularMedia(Iterable<Integer> numeros) {
		if (numeros == null) {
			throw new IllegalArgumentException("El iterable no puede ser null");
		}
		
		double suma = 0;
		int cuenta = 0;

		for (Integer numero : numeros) {
			suma += numero;
			cuenta++;
		}

		if (cuenta == 0) {
			throw new IllegalArgumentException("El iterable no puede estar vacío");
		}
		return suma / cuenta;
	}

	private static double calcularMedia2(Collection<Integer> numeros) {
		if (numeros == null || numeros.isEmpty())
			throw new IllegalArgumentException("La colección de números no puede ser null");
		if (numeros.size() == 0)
			return 0;
		double suma = 0;
		for (Integer numero : numeros) {
			suma += numero;
		}
		return suma / numeros.size();
	}

	private static double calcularMedia3(List<Integer> numeros) {
		double suma = 0;
		for (int i = 0; i < numeros.size(); i++) {
			suma += numeros.get(i);
		}
		return suma / numeros.size();
	}

	private static int obtenerMaximo(Collection<Integer> numeros) {
		if (numeros == null || numeros.isEmpty())
			throw new IllegalArgumentException("La colección de números no puede ser null ni estar vacía");
		int maximo = Integer.MIN_VALUE;
		for (Integer numero : numeros) {
			if (numero > maximo) {
				maximo = numero;
			}
		}
		return maximo;
	}

	private static int obtenerMinimo(Collection<Integer> numeros) {
		if (numeros == null || numeros.isEmpty())
			throw new IllegalArgumentException("La colección de números no puede ser null ni estar vacía");
		int minimo = Integer.MAX_VALUE;
		for (Integer numero : numeros) {
			if (numero < minimo) {
				minimo = numero;
			}
		}
		return minimo;
	}

	private static void leerValoresUsuario(ArrayList<Integer> numeros) {
		Integer numero;
		while ((numero = pedirNumero()) != -9999) {
			numeros.add(numero);
		}
	}

	private static Integer pedirNumero() {
		while (true) {
			try {
				System.out.println("Introduce un número. -9999 para terminar");
				int numero = Integer.parseInt(scanner.nextLine());
				return numero;
			} catch (NumberFormatException e) {
				System.out.println("El valor introducido no es un número entero válido.");
			}
		}
	}
}
