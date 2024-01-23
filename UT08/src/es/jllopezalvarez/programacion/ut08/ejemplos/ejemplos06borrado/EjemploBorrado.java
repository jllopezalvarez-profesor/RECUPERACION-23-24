package es.jllopezalvarez.programacion.ut08.ejemplos.ejemplos06borrado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class EjemploBorrado {

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<>();

		Random rnd = new Random();

		for (int i = 0; i < 10; i++) {
			lista.add(rnd.nextInt(10));
		}

		System.out.println("1");
		System.out.println(lista);

		// Falla porque no se puede borrar al iterar
//		for (Integer num : lista) {
//			if (num %2 == 0) {
//				lista.remove(num);
//			}
//		}

		for (int i = lista.size() - 1; i >= 0; i--) {
			Integer num = lista.get(i);
			if (num % 2 == 0) {
				lista.remove(i);
			}
		}
		System.out.println(lista);
		

		lista.clear();
		
		for(int i=0; i<10; i++) {
			lista.add(rnd.nextInt(10));
		}

		System.out.println(lista);
		
		Iterator<Integer> iterador =  lista.iterator();
		while(iterador.hasNext()) {
			Integer n = iterador.next();
			if (n%2 == 0) {
				iterador.remove();
			}
		}
		
		lista.

		System.out.println(lista);

	}

}
