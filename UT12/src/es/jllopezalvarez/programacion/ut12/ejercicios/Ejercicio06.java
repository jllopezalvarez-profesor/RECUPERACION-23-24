package es.jllopezalvarez.programacion.ut12.ejercicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio06 {
	private static Set<Character> vocales = new HashSet<Character>(
			List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

	private static final Path RUTA_FICHERO_ENTRADA = Path.of("datos", "ficheros", "frases.txt");
	private static final Path RUTA_FICHERO_SALIDA = Path.of("datos", "ficheros", "frasesSinVocales.txt");

	public static void main(String[] args) {
		try (FileReader fr = new FileReader(RUTA_FICHERO_ENTRADA.toString());
				FileWriter fw = new FileWriter(RUTA_FICHERO_SALIDA.toString())) {
			int valorLeido;
			while ((valorLeido = fr.read()) != -1) {
				Character caracterLeido = (char) valorLeido;
				if (!vocales.contains(caracterLeido)) {
					fw.write(caracterLeido);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error al abrir el fichero de entrada");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer o escribir datos");
			e.printStackTrace();
		}

	}

}
