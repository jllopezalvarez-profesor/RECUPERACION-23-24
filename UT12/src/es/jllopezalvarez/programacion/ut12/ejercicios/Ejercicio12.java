package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio12 {

	private static final String VOCALES_CORRECTAS = "aeiouáéíóúAEIOUÁÉÍÓÚ.,";

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Pedimos fichero al usuario
		System.out.print("¿Qué fichero quieres procesar? ");
		String pathFicheroUsuario = scanner.nextLine();

		// Creamos objeto file y comprobamos si exite
		File ficheroEntrada = new File(pathFicheroUsuario);
		if (!ficheroEntrada.exists()) {
			System.out.printf("El fichero %s no existe\n", pathFicheroUsuario);
			return;
		}

		// Variable para cuenta de palabras
		int numPalabras = 0;

		// Mapa para las palabras. Elegimos LinkedHashMap porque este mantiene el orden
		// de inserción.
		Map<String, Integer> palabras = new LinkedHashMap<>();

		// Mapa para las vocales. Elegimos TreeMap porque este ordena por clave
		Map<Character, Integer> vocales = new TreeMap<>();

		// Llenamos el mapa de vocales
		inicializarMapaVocales(vocales);

		// Creamos Scanner
		try (Scanner scannerFichero = new Scanner(new BufferedReader(new FileReader(ficheroEntrada)))) {
			while (scannerFichero.hasNext()) {
				// Leer la palabra
				String palabra = scannerFichero.next();

				// Contar la palabra
				numPalabras++;

				// Incrementar el número de palabras en el mapa de palabras.
				// Si la palabra ya había aparecido antes, incrementamos su valor. Si no había
				// aparecido, el método getOrDefault va a devolver cero (el segundo parámetro),
				// y así ponemos el 1 de la primera aparición.
				palabras.put(palabra, palabras.getOrDefault(palabra, 0) + 1);

				// Procesar las vocales
				for (char c : palabra.toCharArray()) {
					// Comprobamos si está en el mapa, que se ha inicializado con las claves que
					// buscamos

					if (vocales.containsKey(c)) {
						// Es una de las vocales. Incrementamos el número de veces que ha aparecido
						// Aquí no hace falta getOrDefault porque hemos comprobado que la clave existe.
						vocales.put(c, vocales.get(c) + 1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// Esta excepción no debería ocurrir porque el fichero existe, lo hemos
			// verificado, pero puede que no se pueda abrir por otros motivos.
			System.out.printf("No se ha podido abrir el fichero %s\n", ficheroEntrada.getAbsolutePath());
			e.printStackTrace();
			// Salimos del programa
			return;
		}

		// Una vez procesado el texto, generamos el informe.
		File ficheroSalida = new File(ficheroEntrada.getParentFile(), ficheroEntrada.getName() + ".info");
		try (PrintWriter writerInforme = new PrintWriter(ficheroSalida)) {
			// Primera línea: cabecera
			writerInforme.printf("Resultados de procesar el fichero %s.\n", ficheroEntrada.getAbsolutePath());
			// Segunda: fecha
			writerInforme.printf("Fecha de procesamiento: %s.\n", LocalDateTime.now());
			// Tercera: número de palabras
			writerInforme.printf("Número total de palabras en el fichero: %d\n", numPalabras);


			
			// Informe de palabras
			for (Map.Entry<String, Integer> entry : palabras.entrySet()) {
				String palabra = entry.getKey();
				Integer apariciones = entry.getValue();
				writerInforme.printf("%s - %d\n", palabra, apariciones);
			}

			// Informe de vocales
			for (Map.Entry<Character, Integer> entry : vocales.entrySet()) {
				Character vocal = entry.getKey();
				Integer apariciones = entry.getValue();
				writerInforme.printf("%s - %d\n", vocal, apariciones);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido crear el fichero del informe.");
			e.printStackTrace();
		}

	}

	private static void inicializarMapaVocales(Map<Character, Integer> vocales) {
		for (char vocal : VOCALES_CORRECTAS.toCharArray()) {
			vocales.put(vocal, 0);
		}
	}

}
