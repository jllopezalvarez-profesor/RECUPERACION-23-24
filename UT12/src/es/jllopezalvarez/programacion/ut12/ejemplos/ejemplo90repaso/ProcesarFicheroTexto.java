package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplo90repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProcesarFicheroTexto {

	public static void main(String[] args) {
		Path pathFichero1 = Path.of("/home/jllopezalvarez/temp/fichero");
		Path pathFichero2 = Path.of("/", "home", "jllopezalvarez", "temp", "/fichero");
		// Path pathFichero = Path.of("FicherosPrueba", "SubDirA");
		Path pathFichero = Path.of("FicherosPrueba", "StarshipTroopers.txt");

		File fileDatos = pathFichero.toFile();

		if (!fileDatos.exists()) {
			System.out.println("El fichero no existe");
			return;
		}

		if (!fileDatos.isFile()) {
			System.out.println("El fichero no es un fichero");
			return;
		}

		// Leer todas las palabras del fichero
		// Vamos a contar cuantas veces aparece cada una
		// Vamos a guardar en un fichero resultados.txt una lista de palabras con las
		// veces que aparece cada una

		// Sin ordenar
		//Map<String, Integer> frecuencias = new HashMap<>();
		// Ordenado por clave
		// Map<String, Integer> frecuencias = new TreeMap<>();
		// Ordenado por orden de inserción
		Map<String, Integer> frecuencias = new LinkedHashMap<>();

		try (Scanner scanner = new Scanner(fileDatos)) {
			scanner.useDelimiter("[\\s\\-!—\\.\\,…]");
			// scanner.useDelimiter("a");
			while (scanner.hasNext()) {
				String palabra = scanner.next();
				// System.out.println(palabra);
				if (frecuencias.containsKey(palabra)) {
					// La palabra ya había aparecido
					int cuantasVeces = frecuencias.get(palabra);
					frecuencias.put(palabra, cuantasVeces + 1);
				} else {
					// "palabra" aparece por primera vez
					frecuencias.put(palabra, 1);
				}
				// Esto hace lo mismo que el if else anterior
				// frecuencias.put(palabra, frecuencias.getOrDefault(palabra, 0)+1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// El fichero no existe
		}

		// Crear, si no existe, el directorio "datosSalida/pruebas" en el mismo
		// directorio que el fichero
		File directorioSalida = Path.of("FicherosPrueba", "datosSalida", "pruebas").toFile();
		directorioSalida.mkdirs();
		
		try(PrintWriter pw = new PrintWriter(Path.of("FicherosPrueba", "datosSalida", "pruebas", "salida.txt").toFile())){
			for (Map.Entry<String, Integer> entry : frecuencias.entrySet()) {
				String palabra = entry.getKey();
				int numVeces = entry.getValue();

				pw.printf("Palabra: %s - Aparece %d veces.\n", palabra, numVeces);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// No puedo crear el fichero o no tengo permisos
		}


	}

}
