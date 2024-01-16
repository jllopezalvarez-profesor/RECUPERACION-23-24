package es.jllopezalvarez.programacion.ut11.ejercicios.ejercicio16;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class Programa {
	public static void main(String[] args) {
		Persona[] personas = new Persona[3];
		
		personas[0] = new Persona("1111", "José Luis", "López", LocalDate.parse("1980-03-09") );
		personas[1] = new Persona("3333", "Juan", "Martínez", LocalDate.parse("1999-03-09") );
		personas[2] = new Persona("2222", "Elena", "Millán",  LocalDate.parse("2003-03-09") );
		
		System.out.println(Arrays.toString(personas));
		Arrays.sort(personas);
		System.out.println(Arrays.toString(personas));
		Comparator<Persona> comparador = new PersonaComparatorByFechaNacimiento();
		Arrays.sort(personas, comparador);
		System.out.println(Arrays.toString(personas));
		Arrays.sort(personas, comparador.reversed());
		System.out.println(Arrays.toString(personas));
		
		Persona buscado = new Persona("1111", "José Luis", null, null);
		int resultado = Arrays.binarySearch(personas, buscado);
		System.out.println("Encontrado en posición " + resultado);
		
		
		
		Persona p1 = new Persona("4444", "Ana", "Cano", LocalDate.parse("1990-03-09") );
		Persona p2 = new Persona("4444", "Ana", "Cano", LocalDate.parse("1995-03-09") );
		System.out.println(p1.compareTo(p2));
		System.out.println(p1.compareTo(p2) == 0);
		System.out.println(p1.equals(p2));
		//System.out.println(p1.compareTo(null));
		System.out.println(p1.equals(null));
		
		
	}

	private static class PersonaComparatorByFechaNacimiento implements Comparator<Persona> {

		@Override
		public int compare(Persona p1, Persona p2) {
			return p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento());
		}

	}

}
