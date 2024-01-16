package es.jllopezalvarez.programacion.ut09.ejemplos.ejemplos07jerarquia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {

		// Ejemplo de try con múltiples catch bien ordenados, del más específico al
		// más general.
		
		try {
			FileReader reader = new FileReader("f.txt");
			reader.close();
		} catch (FileNotFoundException e) {
			// Subclase que hereda de de IOException
		} catch (IOException e) {
			// Superclase de FileNotFoundException
		}
		
		// Al revés Java indica que tenemos un error
		try {
			FileReader reader = new FileReader("f.txt");
			reader.close();
		} catch (IOException e) {
			// Superclase de FileNotFoundException
		} catch (FileNotFoundException e) {
			// Subclase que hereda de de IOException
			// Tiene que ir antes de la superclase, por eso falla.
		}
	}
}
