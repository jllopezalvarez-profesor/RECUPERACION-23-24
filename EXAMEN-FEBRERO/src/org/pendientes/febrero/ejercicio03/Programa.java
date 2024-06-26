package org.pendientes.febrero.ejercicio03;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Programa {
	private static final Path PATH_FICHERO = Path.of("datos", "mascotas.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		
		List<Mascota> mascotas = leerMacotas(PATH_FICHERO);
		
		// Esto es con programación funcional y referencia a métodos
		//  mascotas.forEach(System.out::println);
		
		// con un for-each tradicional:
		for (Mascota mascota : mascotas) {
			System.out.println(mascota);
		}
		
		System.out.println("-".repeat(100));
		
		// Ordenar en orden natural
		mascotas.sort(null);
	
		for (Mascota mascota : mascotas) {
			System.out.println(mascota);
		}
		
		System.out.println("-".repeat(100));
		
		// Ordenar al reves del orden natural
		mascotas.sort(Comparator.reverseOrder());
	
		for (Mascota mascota : mascotas) {
			System.out.println(mascota);
		}

		System.out.println("-".repeat(100));

		// Ordenar por nombre
		mascotas.sort(Comparator.comparing(Mascota::getNombre));
	
		for (Mascota mascota : mascotas) {
			System.out.println(mascota);
		}
		System.out.println("-".repeat(100));

		// Ordenar por nombre y si son iguales los nombres, por id
		mascotas.sort(Comparator.comparing(Mascota::getNombre).thenComparing(Comparator.naturalOrder()));
	
		for (Mascota mascota : mascotas) {
			System.out.println(mascota);
		}

		
		
//		Collections.sort(mascotas);
		
	}
	
	
	private static List<Mascota> leerMacotas(Path pathFichero) throws FileNotFoundException{
		File fileMascotas = pathFichero.toFile();
		
		if (!fileMascotas.exists()) {
			throw new IllegalArgumentException("No existe el fichero");
		}
		if (!fileMascotas.isFile()) {
			throw new IllegalArgumentException("No es un fichero");
		}
		
		List<Mascota> mascotas = new ArrayList<>();
		
		try(Scanner sc = new Scanner(fileMascotas)){
			while (sc.hasNext()) {
				int id = Integer.parseInt(sc.nextLine());
				String nombre = sc.nextLine();
				String propietario = sc.nextLine();
				int edadMeses = Integer.parseInt(sc.nextLine());
				double pesoKg = Double.parseDouble(sc.nextLine());
				mascotas.add(new Mascota(id, nombre, propietario, edadMeses, pesoKg));
			}
			
		} catch (FileNotFoundException e) {
			throw e;
		}
		
		return mascotas;
		
		
	}

}
