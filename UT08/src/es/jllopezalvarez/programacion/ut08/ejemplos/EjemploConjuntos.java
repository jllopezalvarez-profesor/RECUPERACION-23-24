package es.jllopezalvarez.programacion.ut08.ejemplos;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class EjemploConjuntos {
public static void main(String[] args) {
	Set<String> palabras = new HashSet<>();
	
	String texto = "Hola a todos. Hola a todos de nuevo. A ver cómo va esto.";
	
	for (String palabra : texto.split("[\\s\\.]")) {
		palabras.add(palabra);
	}
	
	System.out.println(palabras);
}
	
	
}
