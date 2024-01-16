package es.jllopezalvarez.programacion.ut12.ejemplos.ejemplos03texto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Ejemplo06LeerFichero {

	public static void main(String[] args) {
		// Este fichero se debe encontrar dentro del directorio donde se ejecuta el
		// programa. Si estamos en Eclipse, dentro de la carpeta del proyecto.
		try (FileReader fr = new FileReader("FicherosPrueba/frases.txt")) {
		//try (FileReader fr = new FileReader(new File("FicherosPrueba/frases.txt"))) {

			int c;
			while ((c = fr.read()) != -1) {
				// System.out.println(c);
				System.out.print((char) c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero, o no se puede abrir.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el fichero.");
			e.printStackTrace();
		}

	}
}
