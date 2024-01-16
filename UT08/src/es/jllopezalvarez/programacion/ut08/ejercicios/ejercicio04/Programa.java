package es.jllopezalvarez.programacion.ut08.ejercicios.ejercicio04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Programa {

	private static Random rnd = new Random();
	private static final int CANTIDAD_NUMEROS = 50;
	private static final int MIN_NUM = 1;
	private static final int MAX_NUM = 25;

	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			numeros.add(rnd.nextInt(MIN_NUM, MAX_NUM + 1));
		}
		
		List<Integer> sinUltimos = new ArrayList<>(numeros); 
		eliminarDuplicadosAlFinal(sinUltimos);
		
		List<Integer> sinPrimeros = new ArrayList<>(numeros); 
		eliminarDuplicadosAlInicio(sinPrimeros);
		
		System.out.println(numeros);
		System.out.println(sinUltimos);
		System.out.println(sinPrimeros);

	}

	private static void eliminarDuplicadosAlFinal(Iterable<Integer> lista) {
		List<Integer> encontrados = new ArrayList<>();

		Iterator<Integer> iterador = lista.iterator();
		while (iterador.hasNext()) {
			Integer numero = iterador.next();
			if (!encontrados.contains(numero)) {
				encontrados.add(numero);
			} else {
				iterador.remove();
			}
		}
	}

	private static void eliminarDuplicadosAlInicio(List<Integer> lista) {
		List<Integer> encontrados = new ArrayList<>();

		ListIterator<Integer> iterador = lista.listIterator(lista.size());
		while (iterador.hasPrevious()) {
			Integer numero = iterador.previous();
			if (!encontrados.contains(numero)) {
				encontrados.add(numero);
			} else {
				iterador.remove();
			}
		}
	}

}
