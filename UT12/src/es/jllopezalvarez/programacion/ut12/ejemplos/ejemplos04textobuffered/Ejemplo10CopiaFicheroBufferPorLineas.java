package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos04textobuffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * 
 * Copiar un fichero en bloques de bytes usando streams (Reader y Writer) con
 * buffer de Java.
 *
 */
public class Ejemplo10CopiaFicheroBufferPorLineas {
	private static final Path PATH_FICHERO_ENTRADA = Path.of("FicherosPrueba", "StarshipTroopers.txt");
	private static final Path PATH_FICHERO_SALIDA = Path.of("FicherosPrueba", "StarshipTroopers.copia.porlineas.txt");

	public static void main(String[] args) {

		// Usamos un objeto file para comprobar que el fichero de origen existe.
		File f = PATH_FICHERO_ENTRADA.toFile();

		// Comprobamos dos cosas: que exista, y que sea un fichero. El objeto File puede
		// representar un directorio. Uso una guard clause para evitar el else
		if (!f.exists() || !f.isFile()) {
			System.out.println("No existe el fichero '" + f.getAbsolutePath() + "' o no es un fichero.");
			return;
		}

		// Usamos try-with-resources para garantizar el cierre de los ficheros.
		// Usamos los tipos BufferedReader y BufferedWriter al definir los objetos, en
		// lugar de las clases abstractas Reader y Writer, porque nos interesa usar
		// específicamente métodos de las subclases.
		try (BufferedReader in = new BufferedReader(new FileReader(f));
				BufferedWriter out = new BufferedWriter(new FileWriter(PATH_FICHERO_SALIDA.toFile()))) {
			// Vamos a copiar línea por línea, así que en lugar de array suamos String
			String linea;
			int numLinea = 1;
			// Devuelve null si se llega al final del fichero.
			while ((linea = in.readLine()) != null) {
				System.out.printf("En la lectura nº %d se ha leído una línea de %d caracteres\n", numLinea,
						linea.length());
				// Para escribir tenemos que usar la sobrecarga del método write que recibe un
				// String, y añadir el salto de línea con el método newLine()
				out.write(linea);
				out.newLine();
				System.out.printf("En la escritura nº %d se ha escrito una línea de %d caracteres\n", numLinea,
						linea.length());
				numLinea++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(String.format("No se encuentra el fichero %s\n", f.getAbsolutePath()));
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer del fichero de origen o escribir en el fichero destino.");
			e.printStackTrace();
		}

	}

}