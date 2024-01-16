package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio07 {

//	private static final int MIN_CARACTER = 0x20;
//	private static final int MAX_CARACTER = 0x7E;
	private static final int MIN_CARACTER = 0x41; // Decimal 65
	private static final int MAX_CARACTER = 0x5A; // Decimal 90
	private static final int CANTIDAD_CARACTERES = 10;
	private static Scanner scanner = new Scanner(System.in);
	private static Random rnd = new Random();

	public static void main(String[] args) {
		System.out.println("Nombre del fichero que quieres crear (se creará en datos/ficheros): ");
		String nombreFichero = scanner.nextLine();
		if (nombreFichero.isBlank()) {
			System.out.println("El nombre de fichero no puede estar vacío.");
			return;
		}

		File fichero = Path.of("datos", "ficheros", nombreFichero).toFile();

		if (fichero.exists()) {
			System.out.println("El fichero ya existe.");
			return;
		}

		// Asegurarnos de que el directorio "padre" del fichero que vamos a crear
		// existe. Si no existe se crea y si existe mkdirs() devuelve false, pero no
		// falla.
		fichero.getParentFile().mkdirs();

		List<Character> caracteres = new ArrayList<>(CANTIDAD_CARACTERES);

		for (int i = 0; i < CANTIDAD_CARACTERES; i++) {
			caracteres.add((char) rnd.nextInt(MIN_CARACTER, MAX_CARACTER + 1));
		}

		caracteres.sort(null);

		try (FileWriter fw = new FileWriter(fichero); BufferedWriter bw = new BufferedWriter(fw)) {
			for (Character c : caracteres) {
				bw.write(c);
				bw.newLine();		
			}
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero");
			e.printStackTrace();
		}

	}
}
