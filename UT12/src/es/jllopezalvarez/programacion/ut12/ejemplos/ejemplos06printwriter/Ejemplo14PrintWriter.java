package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos06printwriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Ejemplo14PrintWriter {

	// Alternativa a Path.of
	private static final Path PATH_FICHERO = Paths.get("datos", "ficheros", "PruebaPW01.txt");

	public static void main(String[] args) {
		// Creamos una lista de personas aleatorias
		List<Persona> personas = Persona.generarPersonasAleatorias(20);

		// Creamos el fichero para escribir
		try (PrintWriter pw = new PrintWriter(PATH_FICHERO.toFile())) {
			String cadenaFormato = "|%d | %s | %s | %s | %f |%n";
			for (Persona persona : personas) {
				pw.printf(cadenaFormato, persona.getId(), persona.getNombre(), persona.getApellido(), persona.getMascota(), persona.getPuntuacion());
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido crear el fichero.");
			e.printStackTrace();
		}

	}

}
