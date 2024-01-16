package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio05 {

	private static final Path RUTA_FICHERO = Path.of("datos", "ficheros", "frases.txt");
	private static Scanner scanner = new Scanner(System.in);
	private static String lineSeparator = System.getProperty("line.separator");
	
	public static void main(String[] args) {
		File fichero = RUTA_FICHERO.toFile();
		fichero.getParentFile().mkdirs();
		try (FileWriter fw = new FileWriter(fichero)) {
			System.out.println("Escribe líneas que quieras volcar al fichero. FIN para acabar");
			String linea;
			do {
				linea = scanner.nextLine();
				fw.write(linea);
				fw.write(lineSeparator);
			}while(!linea.equals("FIN"));
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero.");
			e.printStackTrace();
		}
	}
}
