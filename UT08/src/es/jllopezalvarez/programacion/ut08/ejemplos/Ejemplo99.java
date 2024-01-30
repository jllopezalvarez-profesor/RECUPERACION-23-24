package es.jllopezalvarez.programacion.ut08.ejemplos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejemplo99 {

	public static void main(String[] args) {
		List<Alumno> alumnos = new ArrayList<>();

		alumnos.add(new Alumno(2, "Alumno 2", LocalDate.of(2003, 10, 3)));
		alumnos.add(new Alumno(4, "Alumno 4", LocalDate.of(2000, 10, 18)));
		alumnos.add(new Alumno(1, "Alumno 1", LocalDate.of(2002, 10, 3)));
		alumnos.add(new Alumno(3, "Alumno 3", LocalDate.of(2001, 8, 13)));

//		System.out.println(alumnos);
		alumnos.forEach(System.out::println);

		Alumno buscado1 = new Alumno(3, "Alumno 3", LocalDate.of(2001, 8, 13));
		Alumno buscado2 = new Alumno(3, "Alumno 3", LocalDate.of(2001, 8, 10));

		System.out.println(alumnos.indexOf(buscado1));
		System.out.println(alumnos.indexOf(buscado2));

		
		Collections.sort(alumnos);
		alumnos.forEach(System.out::println);

		
//		alumnos.sort(null);
	}

}
