package es.jllopezalvarez.programacion.ut08.ejemplos.ejemplos06borrado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PruebaContains {
	
	
	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona("123456789A", "Persona A"));
		personas.add(new Persona("423456789B", "Persona B"));
		personas.add(new Persona("123456789C", "Persona C"));
		personas.add(null);
		personas.add(new Persona("723456789D", "Persona D"));
		personas.add(new Persona("023456789E", "Persona E"));
		personas.add(null);
	
		
		Persona p = new Persona("123456789A", "Persona A");
		
		System.out.printf("¿Contiene a la persona? %s\n", personas.contains(p));
		System.out.println(personas);
		Collections.sort(personas, Comparator.nullsLast(Comparator.naturalOrder()));
		System.out.println(personas);
//		System.out.println(personas);
	}

}
