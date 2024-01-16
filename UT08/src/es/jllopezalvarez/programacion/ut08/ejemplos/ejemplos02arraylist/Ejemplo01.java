package es.jllopezalvarez.programacion.ut08.ejemplos.ejemplos02arraylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Ejemplo01 {
	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			int numero = new Random().nextInt(100);
			// System.out.println(numero);
			numeros.add(numero);
			numeros.add(13);
		}

		System.out.println("-".repeat(20));
		System.out.println(numeros);

		numeros.remove(13);

		System.out.println(numeros);

		numeros.remove(Integer.valueOf(13));

		System.out.println(numeros);

		ArrayList<Alumno> alumnos = new ArrayList<>(70);

		System.out.println(alumnos);
		System.out.println(alumnos.size());
		alumnos.add(new Alumno(1111, "Alumno 1 - José"));
		alumnos.add(new Alumno(2222, "Alumno 2 - Juan"));
		alumnos.add(new Alumno(3333, "Alumno 3 - Marcos"));
		alumnos.add(new Alumno(1111, "Alumno 1 - Alicia"));
		System.out.println(alumnos);
		
		Alumno alumnoAEliminar = new Alumno();
		alumnoAEliminar.setId(2222);
		alumnos.remove(alumnoAEliminar);
		System.out.println(alumnos);
		
		alumnos.sort(null);
		System.out.println(alumnos);
		alumnos.sort(Comparator.reverseOrder());
		System.out.println(alumnos);
		
		alumnos.add(1, null);
		System.out.println(alumnos);
			
	
		alumnos.sort(Comparator.nullsFirst(new ByNameAlumnoComparator()));
		System.out.println(alumnos);
	
		
		


	}
}
